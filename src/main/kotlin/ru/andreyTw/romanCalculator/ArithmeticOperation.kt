package ru.andreyTw.romanCalculator

abstract class ArithmeticOperation(
    protected val a2X: (arabic: Int) -> String,
    protected val x2A: (x: String) -> Int,
) {

    abstract fun oper(): (a: Int, b: Int) -> Int

    fun apply(a: String, b: String): String {
        return a2X(oper()(x2A(a), x2A(b)))
    }
}