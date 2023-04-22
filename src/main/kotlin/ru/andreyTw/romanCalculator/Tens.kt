package ru.andreyTw.romanCalculator

enum class Tens(val arabianValue: Int, val romanValue: String){
    TEN(10, "X"),
    TWENTY(20, "XX"),
    THIRTY(30, "XXX"),
    FORTY(40, "XL"),
    FIFTY(50, "L"),
    SIXTY(60, "LX"),
    SEVENTY(70, "LXX"),
    EIGHTY(80, "LXXX"),
    NINETY(90, "XC")
}