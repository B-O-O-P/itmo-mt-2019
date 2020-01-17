package ru.itmo.chizhikov.examples.calc

fun main(args: Array<String>) {
    while (true) {
        println(CalcParser(CalcLexer(readLine()!!.reader())).parse())
    }
}
