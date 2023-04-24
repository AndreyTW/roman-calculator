package ru.andreyTw.romanCalculator

class EquationParser {
    companion object {
        fun parse(inputEquation: String): Triple<String, String, String> =
            inputEquation.split("+").let {
                Triple(it.first(), it.last(), "+")
            }
    }

}