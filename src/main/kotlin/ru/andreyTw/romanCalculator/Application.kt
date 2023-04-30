package ru.andreyTw.romanCalculator

import ru.andreyTw.romanCalculator.model.RomanNumber

fun main() {

    while (true) {
        print("Enter equation you want to calculate (print \"exit\" to quit program): ")
        val equation = readln()
        if (equation == "exit") break
        val operands = EquationParser.parse(equation)
        val result = when (operands.third) {
            "+" -> RomanNumber(operands.first).add(RomanNumber(operands.second))
            "-" -> RomanNumber(operands.first).subtract(RomanNumber(operands.second))
            "*" -> RomanNumber(operands.first).multiply(RomanNumber(operands.second))
            "/" -> RomanNumber(operands.first).divide(RomanNumber(operands.second))
            else -> "???"
        }
        println("$equation=$result")
    }
}