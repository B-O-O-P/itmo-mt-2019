package ru.itmo.chizhikov.examples.calc

import java.io.Reader
import ru.itmo.chizhikov.runtime.Token
import ru.itmo.chizhikov.runtime.GroupMatcherLexer

private val _literals: Map<Token, String> = mapOf(
    0 to "+",
    1 to "-",
    2 to "^",
    3 to "/",
    4 to "*",
    5 to "(",
    6 to ")"
)

private val _patterns: Map<Token, Regex> = mapOf(
    7 to Regex("[0-9]+"),
    8 to Regex("\\s+")
)

private val _tokensToSkip = setOf(8)

object TOKENS {
    val PLUS = 0
    val MINUS = 1
    val POW = 2
    val DIV = 3
    val MUL = 4
    val O = 5
    val C = 6
    val NUM = 7
    val WS = 8
    val EOF = -1
}

class CalcLexer(reader: Reader)
    : GroupMatcherLexer(reader, _literals, _patterns, _tokensToSkip, TOKENS.EOF)
