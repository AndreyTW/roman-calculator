package ru.andreyTw.romanCalculator.constants

import ru.andreyTw.romanCalculator.model.UnknownOperationException

enum class Operations(val symbol: String, val priority: Int) {
    PLUS("+", 0),
    MINUS("-", 0),
    STAR("*", 1),
    SLASH("/", 1);

    companion object {
        val allOperationSymbolsRegexp: String
            get() = allOperationSymbolsList.joinToString("") { if (it == "-") "\\-" else it }

        val allOperationSymbolsList: List<String>
            get() = values().map { it.symbol }

        fun parseOperationSymbol(symbol: String): Operations =
            values().firstOrNull { it.symbol == symbol } ?: throw UnknownOperationException()
    }
}