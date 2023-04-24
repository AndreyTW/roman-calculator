package ru.andreyTw.romanCalculator

class PlusOperation(
    a2X: (Int) -> String,
    x2A: (String) -> Int
) :
    ArithmeticOperation(a2X, x2A) {

    override fun oper(): (a: Int, b: Int) -> Int =
        { a: Int, b: Int -> a + b }

}

