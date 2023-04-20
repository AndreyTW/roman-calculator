package ru.technicalExcellence.codingDojo

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

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

    @Test
    fun convert_I_to_1() {
        assertEquals(1, RomanConverter.convert("I"))
    }

    object RomanConverter {
        fun convert(roman: String): Int {
            return 1
        }
    }
}