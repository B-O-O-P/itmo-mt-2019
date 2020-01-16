package ru.itmo.chizhikov.generators.data

data class Rule(
    val name: String,
    var productions: List<Production> = ArrayList(),
    var returnType: String? = null,
    var args: List<Pair<String, String>>? = null
) {
    fun getArgs() = args?.joinToString { (n, t) -> "$n: $t" }.orEmpty()
}