package ru.andreyTw.romanCalculator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import ru.andreyTw.romanCalculator.converters.RomanToArabicConverter
import ru.andreyTw.romanCalculator.model.RomanNumberException
import java.util.*
import java.util.stream.Stream

class RomanToArabicConverterShould {

    @ParameterizedTest(name = "{0}")
    @MethodSource("parameters")
    fun convert(entry: Pair<String, Int>) {
        assertEquals(entry.second, RomanToArabicConverter.convert(entry.first))
    }

    companion object {
        @JvmStatic
        fun parameters(): Stream<Pair<String, Int>> = Stream.of(
            Pair("I", 1),
            Pair("II", 2),
            Pair("III", 3),
            Pair("IV", 4),
            Pair("V", 5),
            Pair("DCCCLXXXVIII", 888),
            Pair("M", 1000),
        )
    }

    @Test
    fun throwException_whenMoreThenThreeSameDigitsAreGiven() {
        assertThrows<RomanNumberException> { RomanToArabicConverter.convert("IIII") }
    }

    @Test
    fun throwException_whenLargerDigitFollowsMoreThanOneSmallerDigit() {
        assertThrows<RomanNumberException> { RomanToArabicConverter.convert("IIV") }
    }

    @Test
    fun throwException_whenLargerDigitFollowsIncorrectSmallerDigit() {
        assertThrows<RomanNumberException> { RomanToArabicConverter.convert("IC") }
    }
}