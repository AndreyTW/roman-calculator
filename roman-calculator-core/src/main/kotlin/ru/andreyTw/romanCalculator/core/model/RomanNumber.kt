package ru.andreyTw.romanCalculator.core.model

import ru.andreyTw.romanCalculator.core.constants.Operations
import ru.andreyTw.romanCalculator.core.converters.ArabicToRomanConverter
import ru.andreyTw.romanCalculator.core.converters.RomanToArabicConverter

class RomanNumber : Comparable<RomanNumber> {

    val romanValue: String
    val arabicValue: Int

    constructor(arabicValue: Int) {
        romanValue = ArabicToRomanConverter.convert(arabicValue)
        this.arabicValue = arabicValue
    }

    constructor(romanValue: String) {
        arabicValue = RomanToArabicConverter.convert(romanValue)
        this.romanValue = romanValue
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (this.javaClass != other?.javaClass) return false

        other as RomanNumber

        return this.arabicValue.compareTo(other.arabicValue) == 0
    }

    override fun hashCode(): Int =
        this.arabicValue

    override fun compareTo(other: RomanNumber): Int =
        this.arabicValue.compareTo(other.arabicValue)

    override fun toString(): String = romanValue

    fun calculate(other: String, operation: String): RomanNumber = when (Operations.parseOperationSymbol(operation)) {
        Operations.PLUS -> RomanNumber(this.arabicValue + RomanNumber(other).arabicValue)
        Operations.MINUS -> RomanNumber(this.arabicValue - RomanNumber(other).arabicValue)
        Operations.STAR -> RomanNumber(this.arabicValue * RomanNumber(other).arabicValue)
        else -> RomanNumber(this.arabicValue / RomanNumber(other).arabicValue)
    }

}