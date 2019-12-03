package ru.itmo.chizhikov

class Parser(private val lexer: Lexer) {

    private fun skip(token: Token): TreeNode {
        if (lexer.token != token && token != Token.EPS) {
            throw ParseException.expectedNotFound(lexer, token)
        }

        val lastId = lexer.lastId
        val res = TreeNode(
            name = if ((token == Token.ID || token == Token.NUMBER) && lastId != null) {
                lastId
            } else {
                token.toString()
            },
            children = listOf(),
            term = true
        )
        if (token != Token.EPS) {
            lexer.next()
        }
        return res
    }

    private fun S() = when (lexer.token) {
        Token.VAR -> TreeNode(
            "S",
            skip(Token.VAR),
            X(),
            skip(Token.DOUBLECOLON),
            skip(Token.ARRAY),
            skip(Token.OPEN_QBR),
            D(),
            skip(Token.CLOSE_QBR),
            skip(Token.OF),
            T(),
            skip(Token.SEMICOLON)
        )
        else -> throw throw ParseException.expectedNotFound(lexer, Token.VAR)
    }

    private fun T(): TreeNode = TreeNode("T", skip(Token.ID))

    private fun D(): TreeNode = TreeNode("D", R(), Dss())

    private fun Dss(): TreeNode = when (lexer.token) {
        Token.COMMA -> TreeNode("D\'\'", Ds())
        Token.CLOSE_QBR -> TreeNode("D\'\'", skip(Token.EPS))

        else -> throw throw ParseException.expectedNotFound(lexer, Token.COMMA, Token.CLOSE_QBR)
    }

    private fun Ds(): TreeNode = TreeNode("D\'", skip(Token.COMMA), D(), P())

    private fun P(): TreeNode = when (lexer.token) {
        Token.COMMA -> TreeNode("P", Ds())
        Token.CLOSE_QBR -> TreeNode("P", skip(Token.EPS))

        else -> throw throw ParseException.expectedNotFound(lexer, Token.COMMA, Token.CLOSE_QBR)
    }

    private fun R()
            : TreeNode = TreeNode("R", N(), skip(Token.DOUBLEDOT), N())

    private fun N()
            : TreeNode = TreeNode("N", skip(Token.NUMBER))

    private fun X()
            : TreeNode = TreeNode("X", skip(Token.ID),Xss())

    private fun Xss(): TreeNode = when (lexer.token) {
        Token.COMMA -> TreeNode("X\'\'", Xs())
        Token.DOUBLECOLON -> TreeNode("X\'\'", skip(Token.EPS))

        else -> throw throw ParseException.expectedNotFound(lexer, Token.COMMA, Token.DOUBLECOLON)
    }

    private fun Xs(): TreeNode = TreeNode("X\'", skip(Token.COMMA), X(), Y())

    private fun Y(): TreeNode = when (lexer.token) {
        Token.COMMA -> TreeNode("Y", Xs())
        Token.DOUBLECOLON -> TreeNode("Y", skip(Token.EPS))

        else -> throw throw ParseException.expectedNotFound(lexer, Token.COMMA, Token.DOUBLECOLON)
    }

    fun parse(): TreeNode {
        lexer.next()
        return S()
    }

    companion object {
        fun parse(s: String) = Parser(Lexer(s)).parse()
    }
}