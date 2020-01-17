package ru.itmo.chizhikov.examples.pascal

import ru.itmo.chizhikov.TreeNode
import ru.itmo.chizhikov.runtime.Token
import ru.itmo.chizhikov.runtime.ParseException

@Suppress("UNUSED_VARIABLE")
class PascalParser(private val lexer: PascalLexer) {

    private fun skip(token: Token): TreeNode {
        if (lexer.token != token) {
            throw ParseException.expectedNotFound(lexer, token)
        }

        val res = TreeNode(
                name = if ((token == TOKENS.ID || token == TOKENS.NUM)) {
                    "ID OR NUM"
                } else {
                    token.toString()
                },
                children = listOf(),
                term = true
        )
        lexer.next()
        return res
    }

    private fun S() : TreeNode = when(lexer.token) {
        TOKENS.VAR -> {
            val VAR = skip(TOKENS.VAR)
            val x = X()
            val DOUBLECOLON = skip(TOKENS.DOUBLECOLON)
            val ARRAY = skip(TOKENS.ARRAY)
            val OQP = skip(TOKENS.OQP)
            val d = D()
            val CQP = skip(TOKENS.CQP)
            val OF = skip(TOKENS.OF)
            val type = Type()
            val SEMICOLON = skip(TOKENS.SEMICOLON)
            TreeNode("S",VAR,x,DOUBLECOLON,ARRAY,OQP,d,CQP,OF,type,SEMICOLON)
        }
        else -> throw ParseException.expectedNotFound(lexer, TOKENS.VAR)
    }

    private fun D() : TreeNode = when(lexer.token) {
        TOKENS.NUM -> {
            val n : MutableList<TreeNode> = mutableListOf()
            n.add(N())
            val DOUBLEDOT = skip(TOKENS.DOUBLEDOT)
            n.add(N())
            TreeNode("d",n[0],DOUBLEDOT,n[1])
        }
        else -> throw ParseException.expectedNotFound(lexer, TOKENS.NUM)
    }

    private fun X() : TreeNode = when(lexer.token) {
        TOKENS.ID -> {
            val ID = skip(TOKENS.ID)
            TreeNode("x", ID)
        }
        else -> throw ParseException.expectedNotFound(lexer, TOKENS.ID)
    }

    private fun Type() : TreeNode = when(lexer.token) {
        TOKENS.ID -> {
            val ID = skip(TOKENS.ID)
            TreeNode("type", ID)
        }
        else -> throw ParseException.expectedNotFound(lexer, TOKENS.ID)
    }

    private fun N() : TreeNode = when(lexer.token) {
        TOKENS.NUM -> {
            val NUM = skip(TOKENS.NUM)
            TreeNode("n", NUM)
        }
        else -> throw ParseException.expectedNotFound(lexer, TOKENS.NUM)
    }

    fun parse() : TreeNode { 
        lexer.next()
        return S()
    }
}
