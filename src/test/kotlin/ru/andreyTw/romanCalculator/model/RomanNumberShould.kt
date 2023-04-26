package ru.andreyTw.romanCalculator.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * internal value : Int
 */


class RomanNumberShould {

    @Test
    fun beCreatedFromRoman() {
        val expected = 1

        val actual = RomanNumber("I")

        assertEquals(expected, actual.arabicValue)
    }

    @Test
    fun beCreatedFromArabic() {
        val expected = "I"

        val actual = RomanNumber(1)

        assertEquals(expected, actual.romanValue)
    }

    @Test
    fun beEqual() {
        assertEquals(RomanNumber("X"), RomanNumber(10))
    }

    @Test
    fun beComparable() {
        assertEquals(1, RomanNumber("XI").compareTo(RomanNumber(10)))
    }

    @Test
    fun beAddToOtherNumber() {
        assertEquals(21, RomanNumber("XI").add(RomanNumber(10)).arabicValue)
    }
}