package ru.andreyTw.romanCalculator

import ru.andreyTw.romanCalculator.model.EquationException

class EquationParser {
    companion object {
        fun parse(inputEquation: String): Triple<String, String, String> {
            isCorrect(inputEquation)

            return inputEquation.split("+", "-", "*", "/").let {
                Triple(
                    it.first(), it.last(), when {
                        inputEquation.contains("+") -> "+"
                        inputEquation.contains("-") -> "-"
                        inputEquation.contains("*") -> "*"
                        inputEquation.contains("/") -> "/"
                        else -> ""
                    }
                )
            }
        }

        private fun isCorrect(inputEquation: String) {
            if (inputEquation.replace("[CDILMVX+\\-*/]*".toRegex(), "").trim().isNotEmpty())
                throw EquationException()
        }
    }
}