package ru.andreyTw.romanCalculator

val arabicToXConverter = ArabicToRomanConverter::convert
val xToArabicConverter = RomanToArabicConverter::convert
val arithmeticOperation = ArithmeticOperation(arabicToXConverter, xToArabicConverter)

fun main() {

    var isWorking = true
    while (isWorking) {
        print("Enter equation: ")
        val equation = readln()
        val operands = EquationParser.parse(equation)
        val result = arithmeticOperation.plus(operands.first, operands.second)
        println("$equation=$result")
        print("Exit program (Y/n)? ")
        isWorking = readln() != "Y"
    }
}