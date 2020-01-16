package ru.itmo.chizhikov.generators.files

import ru.itmo.chizhikov.generators.*
import ru.itmo.chizhikov.generators.data.ExtendedElem
import ru.itmo.chizhikov.generators.data.ProdElem
import ru.itmo.chizhikov.generators.data.Production
import ru.itmo.chizhikov.generators.data.Rule
import ru.itmo.chizhikov.runtime.ParsingException

class ParserGrammarFilesGenerator(private val collector: GrammarCollector) : AbstractGrammarFilesGenerator() {

    private val first: Map<String, Set<String>> by lazy {
        val fst: MutableMap<String, MutableSet<String>> = mutableMapOf()

        collector.terms.forEach { fst[it] = mutableSetOf(it) }
        collector._rules.forEach { (name, rule) ->
            fst[name] = mutableSetOf()
            if (rule.productions.any { it.first().name == EPS }) fst[name]!!.add(
                EPS
            )
        }

        var changed = true
        while (changed) {
            changed = false
            for ((name, rule) in collector._rules) {
                for (prod in rule.productions) {
                    for (i in prod.indices) {
                        val curNT = prod[i].name
                        if (EPS in fst.getValue(curNT)) {
                            changed = changed || fst.getValue(name).addAll(fst.getValue(curNT))
                            if (i == prod.size - 1) changed = changed || fst.getValue(name).add(EPS)
                        } else {
                            changed = changed || fst.getValue(name).addAll(fst.getValue(curNT))
                            break
                        }
                    }
                }
            }
        }
        return@lazy fst
    }

    private val follow: Map<String, Set<String>> by lazy {
        val flw: MutableMap<String, MutableSet<String>> = mutableMapOf()

        collector.nonTerms.forEach { flw[it] = mutableSetOf() }
        flw.getValue(collector.startNT).add(EOF)

        var changed = true
        while (changed) {
            changed = false
            for ((name, rule) in collector._rules) {
                rule.productions.forEach { prod ->
                    // For A -> aBb, add to FOLLOW(B) all from FIRST(b) except EPS
                    (0..prod.size - 2)
                        .filter { prod[it] is ProdElem.NonTerm }
                        .forEach { i ->
                            changed = changed || flw.getValue(prod[i].name).addAll(
                                first.getValue(prod[i + 1].name).filter { it != EPS }
                            )
                        }

                    // For A -> aB, add to FOLLOW(B) all from FOLLOW(A)
                    if (prod.last() is ProdElem.NonTerm)
                        changed = changed || flw.getValue(prod.last().name).addAll(flw.getValue(name))

                    // For A -> aBb, FIRST(b) has EPS, add to FOLLOW(B) all from FOLLOW(A)
                    if (prod.size > 1 && EPS in first.getValue(prod.last().name)) {
                        val prelast = prod[prod.size - 2]
                        if (prelast is ProdElem.NonTerm)
                            changed = changed || flw.getValue(prelast.name).addAll(flw.getValue(name))
                    }
                }
            }
        }
        return@lazy flw
    }

    override fun generate(grammarName: String) = buildString {
        if (!checkLL1()) {
            throw ParsingException("It is not an LL(1) grammar!")
        }
        val gn = grammarName.capitalize()
        collector.pckg?.let {
            printLine("package $it")
            newLine
        }
        printLine("import ru.itmo.chizhikov.runtime.Token")
        printLine("import ru.itmo.chizhikov.runtime.ParsingException")
        newLine
        printLine("@Suppress(\"UNUSED_VARIABLE\")")
        printLine("class ${gn}Parser(private val lexer: ${gn}Lexer) {")
        newLine
        scoped {
            printLine("private fun skip(token: Token): String {")
            scoped {
                printLine("if (lexer.token != token) throw ParsingException.expectedNotFound(lexer, token)")
                printLine("val res = lexer.tokenValue ?: throw IllegalArgumentException(\"Cannot skip EOF token\")")
                printLine("lexer.next()")
                printLine("return res")
            }
            printLine("}")
            newLine
            for ((name, rule) in collector._rules) {
                printLine(
                    "private fun ${name.capitalize()}(${rule.getArgs()}) : ${rule.returnType
                        ?: "Unit"} = when(lexer.token) {"
                )
                val m = mapRules(name, rule)
                scoped { ->
                    for ((prod, tokens) in m) {
                        // Tokens
                        printLine("${tokens.joinToString { "TOKENS.$it" }} -> {")
                        scoped {
                            // Declarations
                            val lst = listable(prod)
                            lst.forEach { (e, _) ->
                                when (e) {
                                    in collector.terms -> printLine("val $e : MutableList<String> = mutableListOf()")
                                    in collector.nonTerms -> {
                                        val returnType = collector._rules[e]!!.returnType
                                        if (returnType != null)
                                            printLine("val $e : MutableList<$returnType> = mutableListOf()")
                                    }
                                }
                            }

                            // Assignments
                            products@ for (exElem in prod.native) {
                                when (exElem) {
                                    is ExtendedElem.Casual -> {
                                        when (val elem = exElem.elem) {
                                            is ProdElem.Term -> {
                                                if (elem.name == EPS) continue@products
                                                if (elem.name in lst)
                                                    printLine("${elem.name}.add(skip(TOKENS.${elem.name}))")
                                                else
                                                    printLine("val ${elem.name} = skip(TOKENS.${elem.name})")
                                            }
                                            is ProdElem.NonTerm -> {
                                                val callAttrs = elem.callAttrs?.joinToString().orEmpty()
                                                if (elem.name in lst)
                                                    printLine("${elem.name}.add(${elem.name.capitalize()}($callAttrs))")
                                                else
                                                    printLine("val ${elem.name} = ${elem.name.capitalize()}($callAttrs)")
                                            }
                                        }
                                    }
                                    is ExtendedElem.Code -> printLine(exElem.code)
                                }
                            }
                        }
                        printLine("}")
                    }

                    // else (error)
                    printLine(
                        "else -> throw ParsingException.expectedNotFound(lexer, " +
                                "${m.values.flatten().joinToString { "TOKENS.$it" }})"
                    )
                }
                printLine("}")
                newLine
            }
            val startRule = collector._rules.getValue(collector.startNT)

            printLine("fun parse(${startRule.getArgs()}) : ${startRule.returnType ?: "Unit"} { ")
            scoped {
                printLine("lexer.next()")
                printLine("return ${collector.startNT.capitalize()}(${startRule.args?.joinToString { (a, _) -> a }.orEmpty()})")
            }
            printLine("}")
        }
        printLine("}")
    }

    private fun checkLL1(): Boolean {
        var hasLeftRecursion = false
        for ((name, rule) in collector._rules) {
            hasLeftRecursion =
                hasLeftRecursion || rule.productions.any { production -> production.first().name == name }
        }

        var hasRightBranch = false
        for ((name, rule) in collector._rules) {
            hasRightBranch =
                hasRightBranch || rule.productions.any {
                        production1 -> rule.productions.any {
                        production2 -> production1 != production2 && production1.first().name == production2.first().name
                }
                }
        }
        return !hasLeftRecursion && !hasRightBranch
    }

    private fun mapRules(name: String, rule: Rule) = rule.productions
        .associate { prod ->
            if (prod[0].name == EPS) prod to follow.getValue(name).toList()
            else prod to first.getValue(prod[0].name).toList()
        }
        .also {
            it.values.flatten().also {
                if (it.size != it.distinct().size) {
                    throw ParsingException("It is not an LL(1) grammar!")
                }
            }
        }

    private fun listable(prod: Production) =
        prod.asSequence().groupingBy { it.name }.eachCount().filterValues { i -> i > 1 }
}