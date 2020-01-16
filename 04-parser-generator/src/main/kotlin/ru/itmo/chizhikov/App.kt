package ru.itmo.chizhikov


import org.antlr.v4.runtime.CharStream
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTreeWalker
import antlr.ru.itmo.chizhikov.gen.GrammarLexer
import antlr.ru.itmo.chizhikov.gen.GrammarParser
import ru.itmo.chizhikov.generators.GrammarCollector
import ru.itmo.chizhikov.generators.files.LexerGrammarFilesGenerator
import ru.itmo.chizhikov.generators.files.ParserGrammarFilesGenerator
import ru.itmo.chizhikov.generators.files.DefaultTestGrammarFilesGenerator
import ru.itmo.chizhikov.runtime.ParsingException
import java.nio.file.Files
import java.nio.file.Paths

private fun collect(stream: CharStream): GrammarCollector {
    val collector = GrammarCollector()
    val lexer = GrammarLexer(stream)
    val parser = GrammarParser(CommonTokenStream(lexer))
    val walker = ParseTreeWalker()
    walker.walk(collector, parser.file())
    return collector
}

private fun genAll(grammarName: String, targetDir: String, collector: GrammarCollector) {
    val lexer= LexerGrammarFilesGenerator(
        collector
    ) to "Lexer"
    val parser = ParserGrammarFilesGenerator(
        collector
    ) to "Parser"
    val default = DefaultTestGrammarFilesGenerator(
        collector
    ) to "Test"

    listOf(lexer, parser, default).forEach { (generator, postfix) ->
        val out = Paths.get(targetDir, "$grammarName$postfix.kt")
        out.toFile().parentFile.mkdirs()
        Files.newBufferedWriter(out).use { wr ->
            wr.write(generator.generate(grammarName))
        }
    }
}

fun main(args: Array<String>) {
    val inputFile: String?
    val outputDirectory: String?
    if (args.isEmpty()) {
        println("Please, input name of grammar file:")
        inputFile = readLine()
        println("Input path of directory for output:")
        outputDirectory = readLine()
    } else {
        inputFile = args[0]
        outputDirectory = args[1]
    }

    if (inputFile != null && outputDirectory != null) {
        val grammarName = inputFile.removeSuffix(".gram").capitalize()
        val collector = collect(CharStreams.fromFileName(inputFile))

        genAll(grammarName, outputDirectory, collector)
    } else {
        throw ParsingException("Error with handling grammar file or output directory path")
    }
}