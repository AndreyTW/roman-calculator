package ru.andreyTw.romanCalculator

import com.pengrad.telegrambot.TelegramBot
import com.pengrad.telegrambot.UpdatesListener
import com.pengrad.telegrambot.request.SendMessage
import ru.andreyTw.romanCalculator.model.EquationException
import ru.andreyTw.romanCalculator.model.RomanNumber
import java.io.File

fun main() {

    val bot = TelegramBot(File("botKey").readText())
    bot.setUpdatesListener { updates ->
        updates.forEach {
            val message = it.message().text()
            println("Message = \"$message\" was received")
            val result = calculate(message)
            bot.execute(SendMessage(it.message().chat().id(), result))
        }
        UpdatesListener.CONFIRMED_UPDATES_ALL
    }

    while (true) {
        print("Enter equation you want to calculate (print \"exit\" to quit program): ")
        val equation = readln()
        if (equation == "exit") break

        val result = calculate(equation)

        println("$equation=$result")
    }

    bot.shutdown()
}

private fun calculate(equation: String): String = try {
    val operands = EquationParser.parse(equation)
    val result = when (operands.third) {
        "+" -> RomanNumber(operands.first).add(RomanNumber(operands.second))
        "-" -> RomanNumber(operands.first).subtract(RomanNumber(operands.second))
        "*" -> RomanNumber(operands.first).multiply(RomanNumber(operands.second))
        "/" -> RomanNumber(operands.first).divide(RomanNumber(operands.second))
        else -> "???"
    }
    result.toString()
} catch (e: EquationException) {
    "Achtung!!! Wrong symbol is given!!!"
}