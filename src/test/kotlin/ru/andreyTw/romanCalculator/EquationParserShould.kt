package ru.andreyTw.romanCalculator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import ru.andreyTw.romanCalculator.model.EquationException

class EquationParserShould {

    @Test
    fun `return_I_and_I_and_plus_when_I+I_is_given`() {
        val actual = EquationParser.parse("I+I")
        assertEquals(Triple("I", "I", "+"), actual)
    }

    @Test
    fun `return_I_and_I_and_minus_when_I-I_is_given`() {
        val actual = EquationParser.parse("I-I")
        assertEquals(Triple("I", "I", "-"), actual)
    }

    @Test
    fun `return_I_and_I_and_multiply_when_IstarI_is_given`() {
        val actual = EquationParser.parse("I*I")
        assertEquals(Triple("I", "I", "*"), actual)
    }

    @Test
    fun `return_I_and_I_and_divide_when_IslashI_is_given`() {
        val actual = EquationParser.parse("I/I")
        assertEquals(Triple("I", "I", "/"), actual)
    }

    @Test
    fun throwException_whenEquationIsIncorrect() {
        assertThrows<EquationException> { EquationParser.parse("huy") }
    }

    @Test
    fun throwException_whenWrongSymbolsAreGiven() {
        assertThrows<EquationException> { EquationParser.parse("I+G") }
    }

}