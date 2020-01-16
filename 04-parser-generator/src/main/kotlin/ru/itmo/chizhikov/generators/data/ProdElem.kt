package ru.itmo.chizhikov.generators.data

sealed class ProdElem {
    abstract val name: String

    data class Term(override val name: String) : ProdElem()
    data class NonTerm(override val name: String, val callAttrs: List<String>?) : ProdElem()
}