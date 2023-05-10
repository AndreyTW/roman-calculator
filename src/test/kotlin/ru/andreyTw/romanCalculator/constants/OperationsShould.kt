package ru.andreyTw.romanCalculator.constants

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import ru.andreyTw.romanCalculator.constants.Operations.values
import ru.andreyTw.romanCalculator.model.UnknownOperationException

class OperationsShould {

    @Test
    fun parseValidOperations() {
        values().forEach {
            assertEquals(it, Operations.parse(it.symbol))
        }
    }

    @Test
    fun throwUnknownOperationExceptionWhenUnderscoreIsGiven() {
        assertThrows<UnknownOperationException> { Operations.parse("_") }
    }

    @Test
    fun giveRegularExpression() {
        assertEquals("+\\-*/", Operations.regexp)
    }
}