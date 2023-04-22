package ru.andreyTw.romanCalculator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*
import java.util.stream.Stream

/**
 * Task:
 *
 *
 * V + VII * XX = CXLV ?
 * MAX <= 1000
 * brackets - 2nd stage
 *
 * [ ] Roman Numbers <-> Arabic Numbers
 * [ ] Divide input string to operands and operators
 *
 */

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
            Pair("V", 5)
        )
    }
}