package ru.itmo.chizhikov.utils

import org.antlr.v4.runtime.BaseErrorListener
import org.antlr.v4.runtime.RecognitionException
import org.antlr.v4.runtime.Recognizer

class ErrorCollector : BaseErrorListener() {
    private val errors : MutableList<String> = ArrayList()

    override fun syntaxError(recognizer: Recognizer<*, *>?, offendingSymbol: Any?, line: Int, charPositionInLine: Int, msg: String, e: RecognitionException?) {
        errors.add("Line $line:$charPositionInLine, $msg")
    }

    internal fun hasErrors(): Boolean {
        return errors.size != 0
    }

    fun getErrors(): List<String> = errors

    internal fun addError(errorMsg: String) {
        errors.add(errorMsg)
    }
}