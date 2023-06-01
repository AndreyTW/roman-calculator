package ru.andreyTw.romanCalculator.console

import ru.andreyTw.romanCalculator.core.InputExpressionProcessor.processExpression

fun main() {

    while (true) {
        print("Enter equation you want to calculate (print \"exit\" to quit program): ")
        val equation = readln()
        if (equation == "exit") break

        val result = processExpression(equation)

        println("$equation=$result")
    }

}