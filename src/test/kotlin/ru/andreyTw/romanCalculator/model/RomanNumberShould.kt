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
    fun beAddedToOtherNumber() {
        assertEquals(21, RomanNumber("XI").add(RomanNumber(10)).arabicValue)
    }

    @Test
    fun beReducedByOtherNumber() {
        assertEquals(1, RomanNumber("XI").subtract(RomanNumber(10)).arabicValue)
    }

    @Test
    fun beMultipliedByOtherNumber() {
        assertEquals(110, RomanNumber("XI").multiply(RomanNumber(10)).arabicValue)
    }

    @Test
    fun beDividedByOtherNumber() {
        assertEquals(5, RomanNumber("XXVI").divide(RomanNumber(5)).arabicValue)
    }
}