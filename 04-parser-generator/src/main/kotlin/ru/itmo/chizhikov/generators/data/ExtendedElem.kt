package ru.itmo.chizhikov.generators.data

sealed class ExtendedElem {
    data class Casual(val elem: ProdElem) : ExtendedElem()
    data class Code(val code: String) : ExtendedElem()
}