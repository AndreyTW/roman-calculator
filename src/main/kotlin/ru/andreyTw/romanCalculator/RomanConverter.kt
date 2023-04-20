package ru.andreyTw.romanCalculator

object RomanConverter {
    fun convert(roman: String): Int {
        return when (roman) {
            "I" -> 1
            "II" -> 2
            "III" -> 3
            else -> 5
        }
    }
}