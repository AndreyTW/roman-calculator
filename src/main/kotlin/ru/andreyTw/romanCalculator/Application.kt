package ru.andreyTw.romanCalculator

import com.pengrad.telegrambot.TelegramBot
import com.pengrad.telegrambot.UpdatesListener
import com.pengrad.telegrambot.request.SendMessage
import ru.andreyTw.romanCalculator.model.EquationException
import ru.andreyTw.romanCalculator.model.RomanNumber
import ru.andreyTw.romanCalculator.model.RomanNumberException
import java.io.File

fun main() {

    val bot = TelegramBot(File("botKey").readText())
    bot.setUpdatesListener { updates ->
        updates.forEach {
            val message = it.message().text()
            println("Message = \"$message\" was received")
            val result = processExpression(message)
            bot.execute(SendMessage(it.message().chat().id(), result))
        }
        UpdatesListener.CONFIRMED_UPDATES_ALL
    }

    while (true) {
        print("Enter equation you want to calculate (print \"exit\" to quit program): ")
        val equation = readln()
        if (equation == "exit") break

        val result = processExpression(equation)

        println("$equation=$result")
    }

    bot.removeGetUpdatesListener()
    bot.shutdown()
}

private fun processExpression(equation: String): String = try {
    val operands = EquationParser.parse(equation)
    val result = RomanNumber(operands.first).calculate(operands.second, operands.third)
    result.toString()
} catch (e: EquationException) {
    "\nError! Wrong equation is given!"
} catch (e: RomanNumberException) {
    "\nError! Incorrect roman number is given!"
}