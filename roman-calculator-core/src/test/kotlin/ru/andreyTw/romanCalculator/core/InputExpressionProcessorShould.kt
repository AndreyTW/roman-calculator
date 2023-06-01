package ru.andreyTw.romanCalculator.core

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import ru.andreyTw.romanCalculator.core.InputExpressionProcessor.processExpression

class InputExpressionProcessorShould {
    @Test
    fun warnAboutEnteringAnInvalidExpression() {
        assertEquals("\nError! Wrong equation is given!", processExpression("I+-V"))
    }

    @Test
    fun warnAboutEnteringAnInvalidRomanNumber() {
        assertEquals("\nError! Incorrect roman number is given!", processExpression("IIV+C"))
    }

    @Test
    fun `formResultString_CLXXIII_whenExpression_IV+CLXIX_isGiven`() {
        assertEquals("CLXXIII", processExpression("IV+CLXIX"))
    }
}