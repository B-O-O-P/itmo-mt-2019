package ru.itmo.chizhikov.generators.files

abstract class AbstractGrammarFilesGenerator {

    protected var indent = 0

    protected inline fun scoped(block: () -> Unit) {
        indent++
        block()
        indent--
    }

    protected fun StringBuilder.printLine(line: String) {
        for (i in 0 until (4 * indent)) {
            append(" ")
        }
        append(line)
        append(System.lineSeparator())
    }

    protected val StringBuilder.newLine: Unit
        get() {
            append(System.lineSeparator())
            Unit
        }

    protected fun StringBuilder.pop() {
        var i = length - 1
        while (this[i].isWhitespace() && i >= 0) {
            i--
        }
        if (i >= 0) {
            deleteCharAt(i)
        }
    }

    abstract fun generate(grammarName: String): String
}