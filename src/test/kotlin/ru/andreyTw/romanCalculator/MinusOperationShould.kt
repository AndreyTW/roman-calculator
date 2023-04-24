package ru.andreyTw.romanCalculator

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class MinusOperationShould {

    private lateinit var minusOperation: MinusOperation

    @BeforeEach
    fun setUp() {
        val arabicToXConverter = ArabicToRomanConverter::convert
        val xToArabicConverter = RomanToArabicConverter::convert
        minusOperation = MinusOperation(arabicToXConverter, xToArabicConverter)
    }

    @Test
    fun return_II_when_I_and_I_given() {
        val actual = minusOperation.apply("II", "I")

        Assertions.assertEquals("I", actual)
    }

    @Test
    fun return_CMXVI_when_DCCCLX_and_LVI_given() {
        val actual = minusOperation.apply("CMXVI", "LVI")

        Assertions.assertEquals("DCCCLX", actual)
    }

}