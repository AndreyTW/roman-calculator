package ru.andreyTw.romanCalculator

object ArabicToRomanConverter {
    fun convert(arabic: Int): String {
        val units: String =
            (0 until Digits.values().size).joinToString("") { i ->
                if (arabic % 10 == Digits.values()[i].arabianValue) Digits.values()[i].romanValueUnits
                else ""
            }
        val tens: String =
            (0 until Digits.values().size).joinToString("") { i ->
                if (arabic / 10 % 10 == Digits.values()[i].arabianValue) Digits.values()[i].romanValueTens
                else ""
            }
        val hundreds: String =
            (0 until Digits.values().size).joinToString("") { i ->
                if (arabic / 100 % 10 == Digits.values()[i].arabianValue) Digits.values()[i].romanValueHundreds
                else ""
            }
        val thousands: String =
            (0 until Digits.values().size).joinToString("") { i ->
                if (arabic / 1000 % 10 == Digits.values()[i].arabianValue) Digits.values()[i].romanValueThousands
                else ""
            }
        return "$thousands$hundreds$tens$units"
    }
}
