package ru.andreyTw.romanCalculator

import ru.andreyTw.romanCalculator.constants.Digits
import ru.andreyTw.romanCalculator.constants.Operations
import ru.andreyTw.romanCalculator.model.EquationException

class EquationParser {
    companion object {
        fun parse(inputEquation: String): Triple<String, String, String> {
            val inputEquationWithSpacesRemoved = inputEquation.replace(" ", "").also {
                isCorrect(it)
            }

            return inputEquationWithSpacesRemoved.split(*Operations.all.toTypedArray()).let {
                Triple(
                    it.first(),
                    it.last(),
                    "[${Operations.regexp}]".toRegex().find(inputEquationWithSpacesRemoved)?.value ?: ""
                )
            }
        }

        private fun isCorrect(inputEquation: String) {
            if (!inputEquation
                    .matches(
                        "[${Digits.regex}]{1,12}[${Operations.regexp}][${Digits.regex}]{1,12}"
                            .toRegex()
                    )
            )
                throw EquationException()
        }
    }
}