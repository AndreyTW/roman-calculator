package ru.andreyTw.romanCalculator.digits

enum class Hundreds(val arabianValue: Int, val romanValue: String){
    ONE_HUNDRED(100, "C"),
    TWO_HUNDRED(200, "CC"),
    THREE_HUNDRED(300, "CCC"),
    FOUR_HUNDRED(400, "CD"),
    FIVE_HUNDRED(500, "D"),
    SIX_HUNDRED(600, "DC"),
    SEVEN_HUNDRED(700, "DCC"),
    EIGHT_HUNDRED(800, "DCCC"),
    NINE_HUNDRED(900, "CM")
}