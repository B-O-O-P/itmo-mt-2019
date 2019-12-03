package ru.itmo.chizhikov

import org.junit.*
import org.junit.Assert.*
import java.lang.IllegalArgumentException

class ParserTest {
    private fun parseString(string: String) {
        Parser.parse(string)
    }

    private fun getTree(string: String): TreeNode {
        return Parser.parse(string)
    }

    private fun getType(tree: TreeNode): String? = when (tree.name) {
        "S" -> tree.children[8].children[0].name
        else -> throw IllegalArgumentException()
    }

    private fun getName(tree: TreeNode): String? = when (tree.name) {
        "S" -> tree.children[1].children[0].name
        else -> throw IllegalArgumentException()
    }

    private fun getAllNumbers(tree: TreeNode): List<String> = when (tree.name) {
        "S" -> getAllNumbers(tree.children[5])
        "D" -> getAllNumbers(tree.children[0]) + getAllNumbers(tree.children[1])
        "R" -> getAllNumbers(tree.children[0]) + getAllNumbers(tree.children[2])
        "D\'" -> getAllNumbers(tree.children[1]) + getAllNumbers(tree.children[2])
        "P", "D\'\'" -> {
            if (tree.children[0].name != Token.EPS.toString()) {
                getAllNumbers(tree.children[0])
            } else {
                emptyList()
            }
        }
        "N" -> listOf(tree.children[0].name)
        else -> throw IllegalArgumentException()
    }

    @Test
    fun `Variant sample`() {
        parseString("var x: array [1..10] of integer;")
    }

    @Test
    fun `Correct type`() {
        val type = getType(getTree("var x: array [1..10] of integer;"))
        assertNotNull(type)
        assertEquals(type, "integer")
    }

    @Test
    fun `Correct name`() {
        val name = getName(getTree("var x: array [1..10] of integer;"))
        assertNotNull(name)
        assertEquals(name, "x")
    }

    @Test
    fun `Multiple names`(){
        parseString("var x, y: array [1..10,2..112] of integer;")
    }

    @Test
    fun `Multiple ranges`() {
        parseString("var x: array [1..10,2..112] of integer;")
    }

    @Test
    fun `Correct number in multiple ranges`() {
        val numbers = getAllNumbers(getTree("var x: array [1..10,2..112] of integer;"))
        assertNotNull(numbers)
        assertEquals(numbers, listOf("1", "10", "2", "112"))
    }

    @Test(expected = ParseException::class)
    fun `Comma between ranges`() {
        parseString("var x: array [1..10.2..112] of integer;")
    }

    @Test(expected = ParseException::class)
    fun `No closing bracket after ranges`(){
        parseString("var x: array [1..10,2..112 of integer;")
    }

    @Test(expected = ParseException::class)
    fun `More than one type`() {
        parseString("var x: array [1..10] of integer char;")
    }

    @Test(expected = ParseException::class)
    fun `Invalid range`() {
        parseString("var x: array [1. .10] of integer;")
    }

    @Test(expected = ParseException::class)
    fun `Invalid character`() {
        parseString("var *x: array [1..10] of integer;")
    }

    @Test(expected = ParseException::class)
    fun `No double colon`() {
        parseString("var x array [1..10] of integer;")
    }

    @Test(expected = ParseException::class)
    fun `No semi colon`() {
        parseString("var x: array [1..10] of integer")
    }

    @Test(expected = ParseException::class)
    fun `No var`() {
        parseString("x: array [1..10] of integer;")
    }

    @Test(expected = ParseException::class)
    fun `No array`() {
        parseString("var x: [1..10] of integer;")
    }

    @Test(expected = ParseException::class)
    fun `No of`() {
        parseString("var x: array [1..10] integer;")
    }
}