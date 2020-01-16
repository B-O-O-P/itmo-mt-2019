package ru.itmo.chizhikov.generators.files

import ru.itmo.chizhikov.generators.GrammarCollector

class DefaultTestGrammarFilesGenerator(private val collector: GrammarCollector) : AbstractGrammarFilesGenerator() {
    override fun generate(grammarName: String) = buildString {
        val gn = grammarName.capitalize()
        collector.pckg?.let {
            printLine("package $it")
            newLine
        }
        printLine("fun main(args: Array<String>) {")
        scoped {
            printLine("println(${gn}Parser(${gn}Lexer(args[0].reader())).parse())")
        }
        printLine("}")
    }

}