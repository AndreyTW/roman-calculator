package ru.andreyTw.romanCalculator.core.converters

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class ArabicToRomanConverterShould {

    @ParameterizedTest(name = "{0}")
    @MethodSource("parameters")
    fun convert(entry: Pair<String, Int>) {
        assertEquals(entry.first, ArabicToRomanConverter.convert(entry.second))
    }

    companion object {
        @JvmStatic
        fun parameters(): Stream<Pair<String, Int>> = Stream.of(
            Pair("", 0),
            Pair("I", 1),
            Pair("XX", 20),
            Pair("LVI", 56),
            Pair("CD", 400),
            Pair("DVII", 507),
            Pair("DCCCLX", 860),
            Pair("DCCCLXXXVIII", 888),
            Pair("CMXCIX", 999),
            Pair("M", 1000)
        )
    }
}