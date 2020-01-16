package ru.itmo.chizhikov.generators.data

data class Production(val prods: List<ProdElem>, val native: List<ExtendedElem>) : List<ProdElem> by prods
