package ru.andreyTw.romanCalculator.converters

import ru.andreyTw.romanCalculator.constants.Digits
import ru.andreyTw.romanCalculator.model.RomanNumberException

object RomanToArabicConverter {
    fun convert(roman: String): Int {

        val num = roman.toCharArray().map {
            when (it.toString()) {
                Digits.ONE.romanValueUnits -> Digits.ONE.arabianValue
                Digits.FIVE.romanValueUnits -> Digits.FIVE.arabianValue
                Digits.ONE.romanValueTens -> Digits.ONE.arabianValue * 10
                Digits.FIVE.romanValueTens -> Digits.FIVE.arabianValue * 10
                Digits.ONE.romanValueHundreds -> Digits.ONE.arabianValue * 100
                Digits.FIVE.romanValueHundreds -> Digits.FIVE.arabianValue * 100
                Digits.ONE.romanValueThousands -> Digits.ONE.arabianValue * 1000
                else -> 0
            }
        }

        isRomanInitialConversionCorrect(num)

        return num.reduceIndexed { i, acc, _ ->
            calcSumOfDigits(num, i, acc)
        }
    }

    private fun isRomanInitialConversionCorrect(num: List<Int>) {
        when {
            num.size > 3 -> {
                (3 until num.size).forEach { i ->
                    if (
                        num[i] == num[i - 1] &&
                        num[i] == num[i - 2] &&
                        num[i] == num[i - 3]
                    ) throw RomanNumberException()
                }
            }

            num.size > 2 -> {
                (2 until num.size).forEach { i ->
                    if (
                        num[i] > num[i - 1] &&
                        num[i] > num[i - 2]
                    ) throw RomanNumberException()
                }
            }

            num.size > 1 -> {
                (1 until num.size).forEach { i ->
                    if (num[i] > num[i - 1]) {
                        if (
                            num[i] / num[i - 1] != 5 &&
                            num[i] / num[i - 1] != 10
                        ) throw RomanNumberException()
                    }
                }
            }
        }
    }

    private fun calcSumOfDigits(num: List<Int>, i: Int, acc: Int) =
        if (num[i] > num[i - 1]) acc + num[i] - 2 * num[i - 1] else acc + num[i]
}