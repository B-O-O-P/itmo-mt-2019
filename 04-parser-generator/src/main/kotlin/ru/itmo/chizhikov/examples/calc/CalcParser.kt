package ru.itmo.chizhikov.examples.calc

import ru.itmo.chizhikov.runtime.Token
import ru.itmo.chizhikov.runtime.ParseException

@Suppress("UNUSED_VARIABLE")
class CalcParser(private val lexer: CalcLexer) {

    private fun skip(token: Token): String {
        if (lexer.token != token) throw ParseException.expectedNotFound(lexer, token)
        val res = lexer.tokenValue ?: throw IllegalArgumentException("Cannot skip EOF token")
        lexer.next()
        return res
    }

    private fun Expr() : Int = when(lexer.token) {
        TOKENS.O, TOKENS.NUM -> {
            val term = Term()
            val exprs = Exprs(term)
            exprs
        }
        else -> throw ParseException.expectedNotFound(lexer, TOKENS.O, TOKENS.NUM)
    }

    private fun Exprs(acc: Int) : Int = when(lexer.token) {
        TOKENS.PLUS -> {
            val PLUS = skip(TOKENS.PLUS)
            val term = Term()
            val next = acc + term
            val exprs = Exprs(next)
            exprs
        }
        TOKENS.MINUS -> {
            val MINUS = skip(TOKENS.MINUS)
            val term = Term()
            val next = acc - term
            val exprs = Exprs(next)
            exprs
        }
        TOKENS.EOF, TOKENS.C -> {
            acc
        }
        else -> throw ParseException.expectedNotFound(lexer, TOKENS.PLUS, TOKENS.MINUS, TOKENS.EOF, TOKENS.C)
    }

    private fun Term() : Int = when(lexer.token) {
        TOKENS.O, TOKENS.NUM -> {
            val factor = Factor()
            val terms = Terms(factor)
            terms
        }
        else -> throw ParseException.expectedNotFound(lexer, TOKENS.O, TOKENS.NUM)
    }

    private fun Terms(acc: Int) : Int = when(lexer.token) {
        TOKENS.MUL -> {
            val MUL = skip(TOKENS.MUL)
            val factor = Factor()
            val terms = Terms(acc * factor)
            terms
        }
        TOKENS.DIV -> {
            val DIV = skip(TOKENS.DIV)
            val factor = Factor()
            val terms = Terms(acc / factor)
            terms
        }
        TOKENS.PLUS, TOKENS.MINUS, TOKENS.EOF, TOKENS.C -> {
            acc
        }
        else -> throw ParseException.expectedNotFound(lexer, TOKENS.MUL, TOKENS.DIV, TOKENS.PLUS, TOKENS.MINUS, TOKENS.EOF, TOKENS.C)
    }

    private fun Factor() : Int = when(lexer.token) {
        TOKENS.O, TOKENS.NUM -> {
            val single = Single()
            val factors = Factors(single)
            factors
        }
        else -> throw ParseException.expectedNotFound(lexer, TOKENS.O, TOKENS.NUM)
    }

    private fun Factors(acc: Int) : Int = when(lexer.token) {
        TOKENS.POW -> {
            val POW = skip(TOKENS.POW)
            val single = Single()
            val factors = Factors(Math.pow(single.toDouble(),acc.toDouble()).toInt())
            factors
        }
        TOKENS.MUL, TOKENS.DIV, TOKENS.PLUS, TOKENS.MINUS, TOKENS.EOF, TOKENS.C -> {
            acc
        }
        else -> throw ParseException.expectedNotFound(lexer, TOKENS.POW, TOKENS.MUL, TOKENS.DIV, TOKENS.PLUS, TOKENS.MINUS, TOKENS.EOF, TOKENS.C)
    }

    private fun Single() : Int = when(lexer.token) {
        TOKENS.O -> {
            val O = skip(TOKENS.O)
            val expr = Expr()
            val C = skip(TOKENS.C)
            expr
        }
        TOKENS.NUM -> {
            val num = Num()
            num
        }
        else -> throw ParseException.expectedNotFound(lexer, TOKENS.O, TOKENS.NUM)
    }

    private fun Num() : Int = when(lexer.token) {
        TOKENS.NUM -> {
            val NUM = skip(TOKENS.NUM)
            NUM.toInt()
        }
        else -> throw ParseException.expectedNotFound(lexer, TOKENS.NUM)
    }

    fun parse() : Int { 
        lexer.next()
        return Expr()
    }
}
