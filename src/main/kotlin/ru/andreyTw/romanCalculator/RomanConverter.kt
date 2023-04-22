package ru.andreyTw.romanCalculator

import ru.andreyTw.romanCalculator.digits.Units

object RomanConverter {
    fun convert(roman: String): Int {
        return when (roman) {
            Units.ONE.romanValue -> Units.ONE.arabianValue
            Units.TWO.romanValue -> Units.TWO.arabianValue
            Units.THREE.romanValue -> Units.THREE.arabianValue
            else -> Units.FIVE.arabianValue
        }
    }
}

fun main() {
    println(Units.FOUR.arabianValue)
    println(Units.FOUR.romanValue)
}