package ru.andreyTw.romanCalculator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import ru.andreyTw.romanCalculator.constants.Operations
import ru.andreyTw.romanCalculator.constants.Operations.*
import ru.andreyTw.romanCalculator.model.EquationException
import java.util.stream.Stream

class EquationParserShould {

    @ParameterizedTest(name = "{0}")
    @MethodSource("equationParseParameters")
    fun returnTripleOfOperandsAndOperation(entry: Pair<String, Operations>) {
        val actual = EquationParser.parse(entry.first)
        assertEquals(Triple("I", "I", entry.second.symbol), actual)
    }

    companion object {
        @JvmStatic
        fun equationParseParameters(): Stream<Pair<String, Operations>> = Stream.of(
            Pair("I+I", PLUS),
            Pair("I-I", MINUS),
            Pair("I*I", STAR),
            Pair("I/I", SLASH),
            Pair(" I + I ", PLUS)
        )
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

    @Test
    fun throwException_whenNumberContainsMoreThenTwelveCharacters() {
        assertThrows<EquationException> { EquationParser.parse("V+IIIIIIIIIIIII") }
    }

}