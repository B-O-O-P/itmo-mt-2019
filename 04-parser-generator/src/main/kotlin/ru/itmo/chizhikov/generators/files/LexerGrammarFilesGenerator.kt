package ru.itmo.chizhikov.generators.files

import ru.itmo.chizhikov.generators.GrammarCollector
import ru.itmo.chizhikov.escape
import ru.itmo.chizhikov.runtime.Token

class LexerGrammarFilesGenerator(private val collector: GrammarCollector) : AbstractGrammarFilesGenerator() {

    private val tokensToSkip: Set<Token>
        get() = collector._tokensToSkip

    private val literals: Map<Token, String>
        get() = collector._literals

    private val patterns: Map<Token, Regex>
        get() = collector._patterns

    private val tokenTable: Map<String, Token>
        get() = collector._tokenTable

    override fun generate(grammarName: String) = buildString {
        collector.pckg?.let {
            printLine("package $it")
            newLine
        }
        printLine("import java.io.Reader")
        printLine("import ru.itmo.chizhikov.runtime.Token")
        printLine("import ru.itmo.chizhikov.runtime.GroupMatcherLexer")
        newLine
        printLine("private val _literals: Map<Token, String> = mapOf(")
        scoped { literals.forEach { (t, s) -> printLine("$t to \"${s.escape()}\",") } }
        pop()
        printLine(")")
        newLine
        printLine("private val _patterns: Map<Token, Regex> = mapOf(")
        scoped { patterns.forEach { (t, r) -> printLine("$t to Regex(\"${r.toString().escape()}\"),") } }
        pop()
        printLine(")")
        newLine
        printLine("private val _tokensToSkip = setOf(${tokensToSkip.joinToString()})")
        newLine
        printLine("object TOKENS {")
        scoped { (tokenTable - tokensToSkip).forEach { (t, i) -> printLine("val $t = $i") } }
        printLine("}")
        newLine
        printLine("class ${grammarName.capitalize()}Lexer(reader: Reader)")
        scoped { printLine(": GroupMatcherLexer(reader, _literals, _patterns, _tokensToSkip, TOKENS.EOF)") }
    }
}