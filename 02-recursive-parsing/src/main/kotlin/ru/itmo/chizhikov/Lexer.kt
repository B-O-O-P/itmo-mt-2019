package ru.itmo.chizhikov

import ru.itmo.chizhikov.utils.*
import java.io.IOException
import java.io.Reader
import java.io.StringReader

data class Lexer(private val reader: Reader) {
    lateinit var token: Token

    var lastId: String? = null
        private set

    private var cur: Char = (' ')

    var position: Int = 1
        private set

    constructor(line: String) : this(StringReader(line))

    private fun read() {
        position++
        try {
            cur = reader.read().toChar()
        } catch (e: IOException) {
            throw ParseException(e.message ?: "IO error", position)
        }
    }

    fun next() {
        while (cur.isWhitespace()) read()

        var isId = false
        var isDoubleDot = false
        val builder = StringBuilder()

        while (cur.isLetterOrDigit()) {
            isId = true
            builder.append(cur)
            read()
        }

        if (isId) {
            val someString = builder.toString()
            when {
                someString.isNumber() -> {
                    lastId = someString
                    token = Token.NUMBER
                }
                someString.equals(Token.VAR.toString(), true) -> token = Token.VAR
                someString.equals(Token.ARRAY.toString(), true) -> token = Token.ARRAY
                someString.equals(Token.OF.toString(), true) -> token = Token.OF
                else -> {
                    lastId = someString
                    token = Token.ID
                }
            }
            return
        }

        if (cur == '.') {
            builder.append(cur)
            read()
            if (cur == '.') {
                builder.append(cur)
                read()
                isDoubleDot = true
            }
        }

        if (isDoubleDot) {
            token = Token.DOUBLEDOT
            return
        }

        when (cur) {
            ',' -> {
                token = Token.COMMA
                read()
            }

            ';' -> {
                token = Token.SEMICOLON
                read()
            }

            ':' -> {
                token = Token.DOUBLECOLON
                read()
            }

            '[' -> {
                token = Token.OPEN_QBR
                read()
            }

            ']' -> {
                token = Token.CLOSE_QBR
                read()
            }

            (-1).toChar() -> {
                token = Token.EOF
            }

            else -> throw ParseException("Illegal character", position)
        }
    }
}