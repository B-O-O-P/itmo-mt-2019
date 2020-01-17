package ru.itmo.chizhikov

import java.io.Writer

class TreePrinter(private val tree: TreeNode, var name: String = "") {
    private lateinit var writer: Writer

    fun printTo(output: Writer) {
        this.writer = output
        writer.write("digraph $name {")
        writer.write(System.lineSeparator())
        printNodeNamesRec(tree)
        printNodeLinksRec(tree)
        writer.write("}")
    }

    private fun TreeNode.uniqueId() = "node" + System.identityHashCode(this)

    private fun printNodeNamesRec(cur: TreeNode) {
        printNodeName(cur)
        cur.children.forEach { printNodeNamesRec(it) }
    }

    private fun printNodeLinksRec(cur: TreeNode) {
        printNodeLinks(cur)
        cur.children.forEach { printNodeLinksRec(it) }
    }

    private fun printNodeName(cur: TreeNode) {
        val name = cur.name
        val attrs = mutableMapOf("label" to "\"$name\"")
        if (cur.term) {
            attrs["color"] = "red"
        } else if (cur.children.isEmpty()) {
            attrs["style"] = "filled"
            attrs["fillcolor"] = "lightgray"
        }
        val attrString = attrs.map { (k, v) -> "$k=$v" }.joinToString()
        writer.write("${cur.uniqueId()}[$attrString]")
        writer.write(System.lineSeparator())
    }

    private fun printNodeLinks(cur: TreeNode) {
        if (cur.children.isEmpty()) return
        val l = cur.children.joinToString(separator = " ") { it.uniqueId() }
        writer.write("${cur.uniqueId()} -> {$l}")
        writer.write(System.lineSeparator())
    }
}

data class TreeNode(val name: String, val children: List<TreeNode>, val term: Boolean = false) {
    constructor(name: String, vararg children: TreeNode) : this(name, children.asList())

}
