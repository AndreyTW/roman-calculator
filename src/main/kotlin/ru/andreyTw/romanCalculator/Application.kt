package ru.andreyTw.romanCalculator

import ru.andreyTw.romanCalculator.converters.ArabicToRomanConverter
import ru.andreyTw.romanCalculator.converters.RomanToArabicConverter

val arabicToXConverter = ArabicToRomanConverter::convert
val xToArabicConverter = RomanToArabicConverter::convert
val arithmeticOperation = ArithmeticOperation(arabicToXConverter, xToArabicConverter)

fun main() {

    while (true) {
        print("Enter equation you want to calculate (print \"exit\" to quit program): ")
        val equation = readln()
        if (equation == "exit") break
        val operands = EquationParser.parse(equation)
        val result = when (operands.third) {
            "+" -> arithmeticOperation.sum(operands.first, operands.second)
            "-" -> arithmeticOperation.subtract(operands.first, operands.second)
            "*" -> arithmeticOperation.multiply(operands.first, operands.second)
            "/" -> arithmeticOperation.divide(operands.first, operands.second)
            else -> "???"
        }
        println("$equation=$result")
    }
}