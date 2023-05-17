package ru.andreyTw.romanCalculator.telegram

import com.pengrad.telegrambot.TelegramBot
import com.pengrad.telegrambot.UpdatesListener
import com.pengrad.telegrambot.request.SendMessage
import ru.andreyTw.romanCalculator.core.InputExpressionProcessor.Companion.processExpression
import sun.misc.Signal
import java.io.File
import kotlin.system.exitProcess

val bot = TelegramBot(File("botKey").readText())

fun main() {
    println("Application is starting!")
    init()
    Signal.handle(Signal("INT")) {
        shutdown()
        println("Application is closing!")
        exitProcess(0)
    }
    while (true) {
    }
}

private fun init() {
    println("Telegram bot is initializing...")

    bot.setUpdatesListener { updates ->
        updates.forEach {
            val message = it.message().text()
            println("Expression \"$message\" was successfully received")
            val result = processExpression(message)
            bot.execute(SendMessage(it.message().chat().id(), result))
        }
        UpdatesListener.CONFIRMED_UPDATES_ALL
    }
}

private fun shutdown() {
    println("Telegram bot is shutting down...")

    bot.removeGetUpdatesListener()
    bot.shutdown()
}
