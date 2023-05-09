package ru.andreyTw.romanCalculator

import ru.andreyTw.romanCalculator.constants.Operations
import ru.andreyTw.romanCalculator.model.EquationException

class EquationParser {
    companion object {
        fun parse(inputEquation: String): Triple<String, String, String> {
            isCorrect(inputEquation)

            return inputEquation.split(
                Operations.PLUS.symbol,
                Operations.MINUS.symbol,
                Operations.STAR.symbol,
                Operations.SLASH.symbol
            ).let {
                Triple(
                    it.first(), it.last(), when {
                        inputEquation.contains(Operations.PLUS.symbol) -> Operations.PLUS.symbol
                        inputEquation.contains(Operations.MINUS.symbol) -> Operations.MINUS.symbol
                        inputEquation.contains(Operations.STAR.symbol) -> Operations.STAR.symbol
                        inputEquation.contains(Operations.SLASH.symbol) -> Operations.SLASH.symbol
                        else -> ""
                    }
                )
            }
        }

        private fun isCorrect(inputEquation: String) {
            //TODO mb simplification of logic equation is required
            if (inputEquation.count { letter ->
                    letter == Operations.PLUS.symbol.first() ||
                    letter == Operations.MINUS.symbol.first() ||
                    letter == Operations.STAR.symbol.first() ||
                    letter == Operations.SLASH.symbol.first()
                } != 1)
                throw EquationException()
            //TODO mb correction of regex is required
            if (inputEquation.replace("[CDILMVX+\\-*/]*".toRegex(), "").trim().isNotEmpty())
                throw EquationException()
        }
    }
}