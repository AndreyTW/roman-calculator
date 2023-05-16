package ru.andreyTw.romanCalculator.core.constants

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import ru.andreyTw.romanCalculator.core.constants.Operations.values
import ru.andreyTw.romanCalculator.core.model.UnknownOperationException

class OperationsShould {

    @Test
    fun parseValidOperations() {
        values().forEach {
            assertEquals(it, Operations.parseOperationSymbol(it.symbol))
        }
    }

    @Test
    fun throwUnknownOperationExceptionWhenUnderscoreIsGiven() {
        assertThrows<UnknownOperationException> { Operations.parseOperationSymbol("_") }
    }

    @Test
    fun giveRegularExpression() {
        assertEquals("+\\-*/", Operations.allOperationSymbolsRegexp)
    }
}