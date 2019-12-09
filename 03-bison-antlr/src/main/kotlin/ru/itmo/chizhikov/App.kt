package ru.itmo.chizhikov

import org.antlr.v4.runtime.CharStreams
import ru.itmo.chizhikov.utils.executeGcc
import ru.itmo.chizhikov.utils.translate
import java.nio.file.Files
import java.nio.file.Paths

sealed class TranslateResult {
    class Success(val result: String) : TranslateResult()

    class Error(val errors: List<String>) : TranslateResult()
}


fun main(args: Array<String>) {
    val fileInName: String?
    var fileOutName: String? = null
    if (args.isEmpty()) {
        println("Input file name to parse:")
        fileInName = readLine()
        println("Input output file name or leave it empty:")
        fileOutName = readLine()
        if (fileOutName == "") {
            fileOutName = null
        }
    } else {
        fileInName = args[0]
        if (args.size > 1){
            fileOutName = args[1]
        }
    }

    if (fileInName == null) {
        println("You should specify input file and optional output file as command line arguments or via console.")
        return
    }

    println("Please, input name of function to call after translation or leave it empty:")
    val functionToCall: String? = readLine()
    println("Input arguments for this function separated by comma and or leave it empty")
    val arguments: Array<String> = readLine()?.split(',')?.toTypedArray() ?: emptyArray()

    val translation: TranslateResult =
        translate(CharStreams.fromFileName("$fileInName.hs", Charsets.UTF_8), functionToCall, arguments)
    when (translation) {
        is TranslateResult.Success -> {
            if (fileOutName == null) {
                println(translation.result)
            } else {
                Files.newBufferedWriter(Paths.get("$fileInName.cpp"), Charsets.UTF_8)
                    .use { it.write(translation.result) }
                executeGcc("$fileInName","$fileOutName")
            }
        }
        is TranslateResult.Error -> {
            val message = "Following errors occurred during compilation of $fileInName:\n"
            System.err.println(translation.errors.joinToString(prefix = message, separator = "\n"))
        }
    }
}