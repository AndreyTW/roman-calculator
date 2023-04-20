package ru.andreyTw.romanCalculator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*
import java.util.stream.Stream
import kotlin.Pair

/**
 * Task:
 *
 *
 * V + VII * XX = CMV ?
 * MAX <= 1000
 * brackets - 2nd stage
 *
 * [ ] Roman Numbers <-> Arabic Numbers
 * [ ] Divide input string to operands and operators
 *
 */

class RomanConverterShould {

    @ParameterizedTest
    @MethodSource("parameters")
    fun convert(entry: Map.Entry<String, Int>) {
        assertEquals(entry.value, RomanConverter.convert(entry.key))
    }

    @Test
    fun convert_I_to_1() {
        assertEquals(1, RomanConverter.convert("I"))
    }

    @Test
    fun convert_II_to_2() {
        assertEquals(2, RomanConverter.convert("II"))
    }

    @Test
    fun convert_III_to_3() {
        assertEquals(3, RomanConverter.convert("III"))
    }

    @Test
    fun convert_V_to_5() {
        assertEquals(5, RomanConverter.convert("V"))
    }

    companion object {
        @JvmStatic
        fun parameters(): Stream<MutableMap.MutableEntry<String, Int>> {
            val map = HashMap<String, Int>()
            map.put("I", 1)
            return map.entries.stream()
        }
    }

}