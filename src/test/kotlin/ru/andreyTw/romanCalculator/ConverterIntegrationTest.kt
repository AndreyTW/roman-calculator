package ru.andreyTw.romanCalculator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import ru.andreyTw.romanCalculator.converters.ArabicToRomanConverter
import ru.andreyTw.romanCalculator.converters.RomanToArabicConverter
import java.util.stream.Stream

class ConverterIntegrationTest {

    @ParameterizedTest(name = "{0}")
    @MethodSource("numbers")
    fun checkArabicVSRoman(number: Int) {
        val actual = RomanToArabicConverter.convert(
            ArabicToRomanConverter.convert(number)
        )

        assertEquals(number, actual)
    }


    companion object {
        @JvmStatic
        fun numbers(): Stream<Int> =
            (0..20).map { (Math.random() * 1000 + 1).toInt() }.toList().stream()
    }
}