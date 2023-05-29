package ru.andreyTw.romanCalculator.core

import ru.andreyTw.romanCalculator.core.constants.Digits
import ru.andreyTw.romanCalculator.core.constants.Operations
import ru.andreyTw.romanCalculator.core.model.EquationException


object EquationParser {
    fun parse(inputEquation: String): Triple<String, String, String> {
        val inputEquationWithSpacesRemoved = inputEquation.replace(" ", "").also {
            isCorrect(it)
        }

        return inputEquationWithSpacesRemoved.split(*Operations.allOperationSymbolsList.toTypedArray()).let {
            Triple(
                it.first(),
                it.last(),
                "[${Operations.allOperationSymbolsRegexp}]".toRegex().find(inputEquationWithSpacesRemoved)!!.value
            )
        }
    }

    private fun isCorrect(inputEquation: String) {
        if (!inputEquation
                .matches(
                    "[${Digits.regex}]{1,12}[${Operations.allOperationSymbolsRegexp}][${Digits.regex}]{1,12}"
                        .toRegex()
                )
        )
            throw EquationException()
    }
}