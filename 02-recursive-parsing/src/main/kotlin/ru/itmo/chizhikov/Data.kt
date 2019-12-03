package ru.itmo.chizhikov

enum class Token {
    ID, COMMA, VAR, ARRAY, OF, DOUBLEDOT, SEMICOLON, DOUBLECOLON, OPEN_QBR, CLOSE_QBR, NUMBER, EPS, EOF;

    override fun toString(): String {
        return when (this) {
            ID -> "<id>"
            COMMA -> ","
            VAR -> "var"
            ARRAY -> "array"
            OF -> "of"
            DOUBLEDOT -> ".."
            SEMICOLON -> ";"
            DOUBLECOLON -> ":"
            OPEN_QBR -> "["
            CLOSE_QBR -> "]"
            NUMBER -> "<id>"
            EPS -> "ε"
            EOF -> "EOF"
        }
    }
}

data class TreeNode(val name: String, val children: List<TreeNode>, val term: Boolean = false) {
    constructor(name: String, vararg children: TreeNode) : this(name, children.asList())

}

