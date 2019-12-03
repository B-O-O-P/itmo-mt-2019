package ru.itmo.chizhikov

import org.junit.*
import org.junit.Assert.*

class LexerTest {
    private lateinit var lexer: Lexer

    private fun Lexer.consume() {
        do {
            this.next()
        } while (this.token != Token.EOF)
    }

    private fun initLexer(string: String) {
        lexer = Lexer(string)
        lexer.next()
    }

    private fun hasToken(lexer: Lexer, token: Token): Boolean {
        while (lexer.token != Token.EOF) {
            if (lexer.token == token) {
                return true
            }
            lexer.next()
        }
        return false
    }

    private fun getLastId(lexer: Lexer): String? {
        lexer.consume()
        return lexer.lastId
    }

    private fun assertOrder(lexer: Lexer, order: List<Token>) {
        for (token in order) {
            assertEquals(token, lexer.token)
            lexer.next()
        }
    }

    @Test
    fun `Name check`() {
        val testString = "integer"
        initLexer(testString)
        assertTrue(hasToken(lexer, Token.ID))
    }

    @Test
    fun `Whitespace check`() {
        val testString = "   integer   "
        initLexer(testString)
        assertTrue(hasToken(lexer, Token.ID))
        assertEquals("integer", getLastId(lexer))
    }

    @Test
    fun `Name and Number`() {
        val testString = "10 integer"
        initLexer(testString)
        assertTrue(hasToken(lexer, Token.NUMBER))
        assertTrue(hasToken(lexer, Token.ID))
    }

    @Test
    fun `Different blanks`() {
        val testString = "\t\rinteger\nchar   "
        initLexer(testString)
        assertTrue(hasToken(lexer, Token.ID))
        assertEquals("char", getLastId(lexer))
    }

    @Test
    fun `Variable name and type`() {
        val testString = "x integer"
        initLexer(testString)
        assertOrder(lexer, listOf(Token.ID, Token.ID, Token.EOF))
    }

    @Test(expected = ParseException::class)
    fun `Illegal character throws exception`() {
        val testString = "var x : * integer"
        initLexer(testString)
        lexer.consume()
    }

    @Test
    fun `Multiple ranges`() {
        val testString = "[1..10,1..11]"
        initLexer(testString)
        assertOrder(
            lexer,
            listOf(
                Token.OPEN_QBR,
                Token.NUMBER,
                Token.DOUBLEDOT,
                Token.NUMBER,
                Token.COMMA,
                Token.NUMBER,
                Token.DOUBLEDOT,
                Token.NUMBER,
                Token.CLOSE_QBR
            )
        )
    }

    @Test
    fun `Correct order`() {
        val testString = "var x: array [1..10] of integer;"
        initLexer(testString)
        assertOrder(
            lexer,
            listOf(
                Token.VAR,
                Token.ID,
                Token.DOUBLECOLON,
                Token.ARRAY,
                Token.OPEN_QBR,
                Token.NUMBER,
                Token.DOUBLEDOT,
                Token.NUMBER,
                Token.CLOSE_QBR,
                Token.OF,
                Token.ID,
                Token.SEMICOLON
            )
        )
    }
}