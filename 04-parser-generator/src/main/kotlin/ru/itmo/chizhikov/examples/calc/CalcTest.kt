package ru.itmo.chizhikov.examples.calc

fun main(args: Array<String>) {
    println(CalcParser(CalcLexer(args[0].reader())).parse())
}
