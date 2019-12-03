package ru.itmo.chizhikov

import java.lang.Exception

class ParseException(
    message: String = "Parsing error",
    val position: Int? = null,
    val pairExpectedFound: Pair<List<Token>, Token>? = null
) : Exception(
    buildString {
        append(message)
        if (position != null) {
            append(" at position $position")
        }
        if (pairExpectedFound != null) {
            append(", expected tokens: ${pairExpectedFound.first}, found: ${pairExpectedFound.second}")
        }
    }
) {
    companion object {
        fun expectedNotFound(lexer: Lexer, vararg expected: Token) =
            ParseException(position = lexer.position, pairExpectedFound = (expected.asList() to lexer.token))
    }
}