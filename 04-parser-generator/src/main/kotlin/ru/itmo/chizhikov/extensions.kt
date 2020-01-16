package ru.itmo.chizhikov

fun String.escape() = replace("\\", "\\\\").replace("\"", "\\\"")

fun String.cleanUpCode() = this.trim('{', '}', ' ')
