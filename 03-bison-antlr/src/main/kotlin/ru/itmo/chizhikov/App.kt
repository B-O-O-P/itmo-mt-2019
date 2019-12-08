package ru.itmo.chizhikov

import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import ru.itmo.chizhikov.antlrGenerated.FuncLangLexer
import ru.itmo.chizhikov.antlrGenerated.FuncLangParser
import java.nio.file.Files
import java.nio.file.Paths

fun main() {
    val lexer: FuncLangLexer =
        FuncLangLexer(
            CharStreams.fromFileName(
                "input.hs", Charsets.UTF_8
            )
        )
    val tokens = CommonTokenStream(lexer)
    val parser = FuncLangParser(tokens)
    Files.newBufferedWriter(Paths.get("out.cpp"), Charsets.UTF_8)
        .use { it.write(parser.code().`val`.toString()) }
}