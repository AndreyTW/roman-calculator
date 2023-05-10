package ru.andreyTw.romanCalculator.constants

import ru.andreyTw.romanCalculator.model.UnknownOperationException

enum class Operations(val symbol: String) {
    PLUS("+"),
    MINUS("-"),
    STAR("*"),
    SLASH("/");

    companion object {
        val regexp: String
            get() = all.joinToString("") { if (it == "-") "\\-" else it }

        val all: List<String>
            get() = values().map { it.symbol }

        fun parse(symbol: String): Operations =
            values().firstOrNull { it.symbol == symbol } ?: throw UnknownOperationException()
    }
}