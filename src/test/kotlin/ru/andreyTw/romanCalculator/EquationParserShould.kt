package ru.andreyTw.romanCalculator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class EquationParserShould {

    @Test
    fun `return_I_and_I_and_plus_when_I+I_is_given`() {
        val actual = EquationParser.parse("I+I")
        assertEquals(Triple("I", "I", "+"), actual)
    }

}