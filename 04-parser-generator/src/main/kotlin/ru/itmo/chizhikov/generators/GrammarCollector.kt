package ru.itmo.chizhikov.generators

import antlr.ru.itmo.chizhikov.gen.GrammarBaseListener
import antlr.ru.itmo.chizhikov.gen.GrammarParser
import ru.itmo.chizhikov.cleanUpCode
import ru.itmo.chizhikov.generators.data.ExtendedElem
import ru.itmo.chizhikov.generators.data.ProdElem
import ru.itmo.chizhikov.generators.data.Production
import ru.itmo.chizhikov.generators.data.Rule
import ru.itmo.chizhikov.runtime.Token

const val EPS = "EPS"
const val EOF = "EOF"

class GrammarCollector : GrammarBaseListener() {
    private var tokenCnt = 0

    val _tokenTable: MutableMap<String, Token> = LinkedHashMap()
    val terms: Set<String>
        get() = if (hasEPSprods) _tokenTable.keys + EPS else _tokenTable.keys

    val _patterns: MutableMap<Token, Regex> = HashMap()
    val _literals: MutableMap<Token, String> = HashMap()
    val _tokensToSkip: MutableSet<Token> = HashSet()

    val _rules: MutableMap<String, Rule> = LinkedHashMap()

    private var hasEPSprods = false
    val nonTerms: Set<String>
        get() = _rules.keys

    var pckg: String? = null
    lateinit var startNT: String

    // Package

    override fun exitPckg(ctx: GrammarParser.PckgContext) {
        pckg = ctx.text.removePrefix("+package").cleanUpCode()
    }

    // Parser

    override fun exitStart(ctx: GrammarParser.StartContext) {
        startNT = ctx.NON_TERM().text
    }

    override fun exitParserRulee(ctx: GrammarParser.ParserRuleeContext) {
        val curRule = _rules.getOrPut(ctx.NON_TERM().text, { Rule(ctx.NON_TERM().text) })

        if (ctx.outAttr() != null)
            curRule.returnType = ctx.outAttr().text
        if (ctx.inAttrs() != null)
            curRule.args = ctx.inAttrs().param().map { it.paramName().text to it.paramType().text }

        curRule.productions = ctx.prods().map { prodsCtx ->
            var prod = if (prodsCtx.prod().isEmpty()) {
                hasEPSprods = true
                listOf(ExtendedElem.Casual(ProdElem.Term(EPS)))
            } else
                prodsCtx.prod().map { prodCtx ->
                    if (prodCtx.NON_TERM() != null) {
                        ExtendedElem.Casual(ProdElem.NonTerm(
                            prodCtx.NON_TERM().text,
                            prodCtx.args()?.arg()?.map { it.text.cleanUpCode() }
                        ))
                    } else if (prodCtx.TERM() != null) {
                        ExtendedElem.Casual(ProdElem.Term(prodCtx.TERM().text))
                    } else {
                        ExtendedElem.Code(prodCtx.CODE().text.cleanUpCode())
                    }
                }
            var elems = prod.filterIsInstance<ExtendedElem.Casual>()
            if (elems.isEmpty()) {
                hasEPSprods = true
                elems = listOf(ExtendedElem.Casual(ProdElem.Term(EPS)))
                prod = elems + prod
            }
            Production(elems.map { it.elem }, prod)
        }
    }

    // Lexer

    override fun exitTokenRule(ctx: GrammarParser.TokenRuleContext) {
        fillMap(ctx.TERM().text, ctx.term_value(), false)
    }

    override fun exitSkipRule(ctx: GrammarParser.SkipRuleContext) {
        fillMap(ctx.TERM().text, ctx.term_value(), true)
    }

    override fun exitFile(ctx: GrammarParser.FileContext?) {
        _tokenTable[EOF] = -1
    }

    private fun fillMap(token: String, right: GrammarParser.Term_valueContext, skip: Boolean) {
        val token_id = _tokenTable.getOrPut(token, { tokenCnt++ })
        if (right.STRING() != null) {
            _literals[token_id] = right.STRING().text.trim('\"')
        } else {
            _patterns[token_id] = Regex(right.REGEX().text.trim('\''))
        }
        if (skip) {
            _tokensToSkip.add(token_id)
        }
    }
}