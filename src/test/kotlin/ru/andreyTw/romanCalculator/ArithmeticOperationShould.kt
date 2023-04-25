package ru.andreyTw.romanCalculator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import ru.andreyTw.romanCalculator.converters.ArabicToRomanConverter
import ru.andreyTw.romanCalculator.converters.RomanToArabicConverter

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
        val actual = arithmeticOperation.sum("I", "I")

        assertEquals("II", actual)
    }

    @Test
    fun return_CMXVI_when_DCCCLX_and_LVI_given() {
        val actual = arithmeticOperation.sum("DCCCLX", "LVI")

        assertEquals("CMXVI", actual)
    }

    @Test
    fun return_I_when_II_and_I_given() {
        val actual = arithmeticOperation.subtract("II", "I")

        assertEquals("I", actual)
    }

    @Test
    fun return_DCCCLX_when_CMXVI_and_LVI_given() {
        val actual = arithmeticOperation.subtract("CMXVI", "LVI")

        assertEquals("DCCCLX", actual)
    }

    @Test
    fun return_II_when_II_and_I_given() {
        val actual = arithmeticOperation.multiply("II", "I")

        assertEquals("II", actual)
    }

    @Test
    fun return_DCCCLXXXVIII_when_CXI_and_VIII_given() {
        val actual = arithmeticOperation.multiply("CXI", "VIII")

        assertEquals("DCCCLXXXVIII", actual)
    }

    @Test
    fun return_I_when_II_and_II_given() {
        val actual = arithmeticOperation.divide("II", "II")

        assertEquals("I", actual)
    }

    @Test
    fun return_CXI_when_DCCCLXXXIX_and_VIII_given() {
        val actual = arithmeticOperation.divide("DCCCLXXXIX", "VIII")

        assertEquals("CXI", actual)
    }

}