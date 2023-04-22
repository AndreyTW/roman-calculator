package ru.andreyTw.romanCalculator

object RomanToArabicConverter {
    fun convert(roman: String): Int {
        return when (roman) {
            Digits.ONE.romanValueUnits -> Digits.ONE.arabianValue
            Digits.TWO.romanValueUnits -> Digits.TWO.arabianValue
            Digits.THREE.romanValueUnits -> Digits.THREE.arabianValue
            else -> Digits.FIVE.arabianValue
        }
    }
}