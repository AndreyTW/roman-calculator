package ru.andreyTw.romanCalculator.core.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

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

    //TODO RomanNumber.operation(other, operation)
    @ParameterizedTest(name = "{0}")
    @MethodSource("calculateParameters")
    fun beCalculatedUsingGivenOperationAndOtherOperand(entry: Pair<String, RomanNumber>) {
        assertEquals(entry.second, RomanNumber("XXVI").calculate("V", entry.first))
    }

    companion object {
        @JvmStatic
        fun calculateParameters(): Stream<Pair<String, RomanNumber>> = Stream.of(
            Pair("+", RomanNumber("XXXI")),
            Pair("-", RomanNumber("XXI")),
            Pair("*", RomanNumber("CXXX")),
            Pair("/", RomanNumber("V"))
        )
    }
}