package ru.andreyTw.romanCalculator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class PlusOperationShould {

    private lateinit var plusOperation: PlusOperation

    @BeforeEach
    fun setUp() {
        val arabicToXConverter = ArabicToRomanConverter::convert
        val xToArabicConverter = RomanToArabicConverter::convert
        plusOperation = PlusOperation(arabicToXConverter, xToArabicConverter)
    }

    @Test
    fun return_II_when_I_and_I_given() {
        val actual = plusOperation.apply("I", "I")

        assertEquals("II", actual)
    }

    @Test
    fun return_CMXVI_when_DCCCLX_and_LVI_given() {
        val actual = plusOperation.apply("DCCCLX", "LVI")

        assertEquals("CMXVI", actual)
    }

}