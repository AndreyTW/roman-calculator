package ru.andreyTw.romanCalculator.core

import ru.andreyTw.romanCalculator.core.model.EquationException
import ru.andreyTw.romanCalculator.core.model.RomanNumber
import ru.andreyTw.romanCalculator.core.model.RomanNumberException

object InputExpressionProcessor {
    fun processExpression(equation: String): String = try {
        val operands = EquationParser.parse(equation)
        val result = RomanNumber(operands.first).calculate(operands.second, operands.third)
        result.toString()
    } catch (e: EquationException) {
        "\nError! Wrong equation is given!"
    } catch (e: RomanNumberException) {
        "\nError! Incorrect roman number is given!"
    }
}