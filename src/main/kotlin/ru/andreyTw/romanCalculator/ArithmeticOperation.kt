package ru.andreyTw.romanCalculator

class ArithmeticOperation(
    private val a2X: (arabic: Int) -> String,
    private val x2A: (x: String) -> Int,
) {

    fun sum(a: String, b: String): String = apply(a, b) { x1: Int, x2: Int -> x1 + x2 }
    fun subtract(a: String, b: String): String = apply(a, b) { x1: Int, x2: Int -> x1 - x2 }
    fun multiply(a: String, b: String): String = apply(a, b) { x1: Int, x2: Int -> x1 * x2 }
    fun divide(a: String, b: String): String = apply(a, b) { x1: Int, x2: Int -> x1 / x2 }

    private fun apply(a: String, b: String, operation: (Int, Int) -> Int): String = a2X(operation(x2A(a), x2A(b)))
}