package ru.andreyTw.romanCalculator

import org.junit.jupiter.api.Assertions
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
        Assertions.assertEquals(1, RomanConverter.convert("I"))
    }

}