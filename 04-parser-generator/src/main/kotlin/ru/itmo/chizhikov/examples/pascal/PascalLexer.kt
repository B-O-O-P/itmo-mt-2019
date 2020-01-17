package ru.itmo.chizhikov.examples.pascal

import java.io.Reader
import ru.itmo.chizhikov.runtime.Token
import ru.itmo.chizhikov.runtime.GroupMatcherLexer

private val _literals: Map<Token, String> = mapOf(
    0 to "var",
    1 to "array",
    2 to "of",
    3 to "..",
    4 to "[",
    5 to "]",
    6 to ";",
    7 to ":"
)

private val _patterns: Map<Token, Regex> = mapOf(
    8 to Regex("[0-9]+"),
    9 to Regex("[A-Za-z]+"),
    10 to Regex("\\s+")
)

private val _tokensToSkip = setOf(10)

object TOKENS {
    val VAR = 0
    val ARRAY = 1
    val OF = 2
    val DOUBLEDOT = 3
    val OQP = 4
    val CQP = 5
    val SEMICOLON = 6
    val DOUBLECOLON = 7
    val NUM = 8
    val ID = 9
    val WS = 10
    val EOF = -1
}

class PascalLexer(reader: Reader)
    : GroupMatcherLexer(reader, _literals, _patterns, _tokensToSkip, TOKENS.EOF)
