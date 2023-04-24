package ru.andreyTw.romanCalculator

class ArithmeticOperation(
    private val a2X: (arabic: Int) -> String,
    private val x2A: (x: String) -> Int,
) {

    fun plus(a: String, b: String): String = apply(a, b) { x1: Int, x2: Int -> x1 + x2 }
    fun minus(a: String, b: String): String = apply(a, b) { x1: Int, x2: Int -> x1 - x2 }

    private fun apply(a: String, b: String, oper: (Int, Int) -> Int): String = a2X(oper(x2A(a), x2A(b)))
}