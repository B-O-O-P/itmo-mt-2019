package ru.itmo.chizhikov.examples.pascal

import ru.itmo.chizhikov.TreePrinter
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths

fun executeDot(name: String) =
        ProcessBuilder("dot", "-Tsvg", "$name.gv")
                .redirectOutput(File("$name.svg"))
                .redirectError(ProcessBuilder.Redirect.INHERIT)
                .start()
                .waitFor()


fun main(args: Array<String>) {
    var parseString: String? = null
    var name: String? = null
    if (args.isEmpty()) {
        println("Input string to parse:")
        parseString = readLine()
        println("Input name to make tree visualization or leave it empty:")
        name = readLine()
    } else {
        parseString = args[0]
        name = if (args.size == 1) {
            null
        } else {
            args[1]
        }
    }

    if (parseString == null) {
        System.err.println(
                "Please, specify input string as command-line argument" +
                        " and optional output name as second argument" +
                        " or input them via console line by line"
        )
        return
    }

    val tree = PascalParser(PascalLexer(parseString.reader())).parse()
    if (name != null && name != "") {
        Files.newBufferedWriter(Paths.get("$name.gv")).use {
            TreePrinter(tree, name).printTo(it)
        }
        val code = executeDot(name)
        if (code != 0) {
            System.err.println("Something went wrong")
        }
    } else {
        System.out.bufferedWriter().use {
            TreePrinter(tree).printTo(it)
        }
    }}
