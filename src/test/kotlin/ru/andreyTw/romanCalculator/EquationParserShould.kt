package ru.andreyTw.romanCalculator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import ru.andreyTw.romanCalculator.constants.Operations
import ru.andreyTw.romanCalculator.model.EquationException

class EquationParserShould {

    @Test
    fun `return_I_and_I_and_plus_when_I+I_is_given`() {
        val actual = EquationParser.parse("I+I")
        assertEquals(Triple("I", "I", Operations.PLUS.symbol), actual)
    }

    @Test
    fun `return_I_and_I_and_minus_when_I-I_is_given`() {
        val actual = EquationParser.parse("I-I")
        assertEquals(Triple("I", "I", Operations.MINUS.symbol), actual)
    }

    @Test
    fun `return_I_and_I_and_multiply_when_IstarI_is_given`() {
        val actual = EquationParser.parse("I*I")
        assertEquals(Triple("I", "I", Operations.STAR.symbol), actual)
    }

    @Test
    fun `return_I_and_I_and_divide_when_IslashI_is_given`() {
        val actual = EquationParser.parse("I/I")
        assertEquals(Triple("I", "I", Operations.SLASH.symbol), actual)
    }

    @Test
    fun throwException_whenEquationIsIncorrect() {
        assertThrows<EquationException> { EquationParser.parse("asdf") }
    }

    @Test
    fun throwException_whenWrongSymbolsAreGiven() {
        assertThrows<EquationException> { EquationParser.parse("I+G") }
    }

    @Test
    fun throwException_whenMultipleOperationsAreGiven() {
        assertThrows<EquationException> { EquationParser.parse("I+-I") }
    }

    @Test
    fun throwException_whenNoOperationsAreGiven() {
        assertThrows<EquationException> { EquationParser.parse("II") }
    }

}