package ru.itmo.chizhikov.utils

fun Int.isBlank() = Character.isWhitespace(this)

fun Int.isIdChar(): Boolean = isDigit() || isLetter()

fun Int.isDigit(): Boolean = ('0').toInt() <= this && this <= ('9').toInt()

fun Int.isLetter(): Boolean = ('a').toInt() <= this && this <= ('z').toInt()
        || ('A').toInt() <= this && this <= ('Z').toInt()

fun String.isNumber(): Boolean {
    var result = true
    this.forEach {
        result = result && Character.isDigit(it)
    }
    return result
}