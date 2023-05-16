package ru.andreyTw.romanCalculator.telegram

import com.pengrad.telegrambot.TelegramBot
import com.pengrad.telegrambot.UpdatesListener
import com.pengrad.telegrambot.request.SendMessage
import ru.andreyTw.romanCalculator.core.InputExpressionProcessor.Companion.processExpression
import java.io.File

fun main() {

    val bot = TelegramBot(File("botKey").readText())
    var exitFlag = false
    bot.setUpdatesListener { updates ->
        updates.forEach {
            val message = it.message().text()
            println("Expression \"$message\" was successfully received")
            if (message == "exit") {
                exitFlag = true
                bot.removeGetUpdatesListener()
                bot.shutdown()
            } else {
                exitFlag = false
                val result = processExpression(message)
                bot.execute(SendMessage(it.message().chat().id(), result))
            }
        }
        UpdatesListener.CONFIRMED_UPDATES_ALL
    }

    while (!exitFlag) {
        println(exitFlag)
    }

}