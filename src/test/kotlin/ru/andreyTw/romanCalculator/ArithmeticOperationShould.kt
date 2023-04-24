package ru.andreyTw.romanCalculator

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ArithmeticOperationShould {

    private lateinit var arithmeticOperation: ArithmeticOperation

    @BeforeEach
    fun setUp() {
        val arabicToXConverter = ArabicToRomanConverter::convert
        val xToArabicConverter = RomanToArabicConverter::convert
        arithmeticOperation = ArithmeticOperation(arabicToXConverter, xToArabicConverter)
    }

    @Test
    fun return_II_when_I_and_I_given() {
        val actual = arithmeticOperation.plus("I", "I")

        assertEquals("II", actual)
    }

    @Test
    fun return_CMXVI_when_DCCCLX_and_LVI_given() {
        val actual = arithmeticOperation.plus("DCCCLX", "LVI")

        assertEquals("CMXVI", actual)
    }

    @Test
    fun return_I_when_II_and_I_given() {
        val actual = arithmeticOperation.minus("II", "I")

        Assertions.assertEquals("I", actual)
    }

    @Test
    fun return_DCCCLX_when_CMXVI_and_LVI_given() {
        val actual = arithmeticOperation.minus("CMXVI", "LVI")

        Assertions.assertEquals("DCCCLX", actual)
    }

}