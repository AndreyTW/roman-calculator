package ru.andreyTw.romanCalculator.constants

enum class Digits(
    val arabianValue: Int,
    val romanValueUnits: String,
    val romanValueTens: String,
    val romanValueHundreds: String,
    val romanValueThousands: String
){
    ONE(1, "I", "X", "C", "M"),
    TWO(2, "II", "XX", "CC", ""),
    THREE(3, "III", "XXX", "CCC", ""),
    FOUR(4, "IV", "XL", "CD", ""),
    FIVE(5, "V", "L", "D", ""),
    SIX(6, "VI", "LX", "DC", ""),
    SEVEN(7, "VII", "LXX", "DCC", ""),
    EIGHT(8, "VIII", "LXXX", "DCCC", ""),
    NINE(9, "IX", "XC", "CM", "");

    companion object {
        val regex: String = "CDILMVX"
    }
}