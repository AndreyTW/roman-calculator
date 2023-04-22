package ru.andreyTw.romanCalculator

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
            Pair("I", 1),
            Pair("II", 2),
            Pair("III", 3),
            Pair("DCCCLXXXVIII", 888),
            Pair("M", 1000)
        )
    }
}