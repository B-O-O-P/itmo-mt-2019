package ru.itmo.chizhikov.utils

import org.antlr.v4.runtime.CharStream
import org.antlr.v4.runtime.CommonTokenStream
import ru.itmo.chizhikov.TranslateResult
import ru.itmo.chizhikov.antlrGenerated.HaskelMathLexer
import ru.itmo.chizhikov.antlrGenerated.HaskelMathParser
import java.lang.StringBuilder

fun translate(stream: CharStream, functionToCall: String?, arguments: Array<String>): TranslateResult {
    val collector = ErrorCollector()
    val lexer = HaskelMathLexer(stream).apply {
        removeErrorListeners()
        addErrorListener(collector)
    }

    val parser = HaskelMathParser(CommonTokenStream(lexer)).apply {
        removeErrorListeners()
        addErrorListener(collector)
    }

    return try {
        val result = addMainCpp(parser.code().value, functionToCall, arguments)
        if (collector.hasErrors())
            TranslateResult.Error(collector.getErrors())
        else
            TranslateResult.Success(result)
    } catch (e: Exception) {
        e.message?.let { collector.addError(it) }
        TranslateResult.Error(collector.getErrors())
    }
}

fun addMainCpp(functions: StringBuilder, functionToCall: String? = null, arguments: Array<out String>): String {
    functions.insert(0, "#include <iostream>\n")

    functions.append(
        "\n\nint main() {\n"
    )
    if (functionToCall != null && functionToCall != "") {
        functions.append(" std::cout << $functionToCall(${arguments.joinToString(separator = ", ")});\n")
    }
    functions.append("}")

    return functions.toString()
}

fun executeGcc(name: String, out: String) {
    ProcessBuilder("g++", "$name.cpp", "-o", out)
    .redirectOutput(ProcessBuilder.Redirect.INHERIT)
        .redirectError(ProcessBuilder.Redirect.INHERIT)
        .start()
        .waitFor()
    ProcessBuilder("./$out.exe")
        .redirectOutput(ProcessBuilder.Redirect.INHERIT)
        .redirectError(ProcessBuilder.Redirect.INHERIT)
        .start()
        .waitFor()
}