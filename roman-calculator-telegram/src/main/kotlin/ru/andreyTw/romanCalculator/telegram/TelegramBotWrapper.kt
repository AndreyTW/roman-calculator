package ru.andreyTw.romanCalculator.telegram

import com.pengrad.telegrambot.TelegramBot
import com.pengrad.telegrambot.UpdatesListener
import com.pengrad.telegrambot.request.SendMessage
import ru.andreyTw.romanCalculator.core.InputExpressionProcessor

class TelegramBotWrapper(key: String) : BotWrapper {
    private val bot: TelegramBot = TelegramBot(key)

    override fun init() {
        bot.setUpdatesListener { updates ->
            updates.forEach {
                val message = it.message().text()
                println("Expression \"$message\" was successfully received")
                val result = InputExpressionProcessor.processExpression(message)
                bot.execute(SendMessage(it.message().chat().id(), result))
            }
            UpdatesListener.CONFIRMED_UPDATES_ALL
        }
    }

    override fun sendMessage(chatId: String, message: String) {
        TODO("Not yet implemented")
    }

    override fun shutdown() {
        bot.removeGetUpdatesListener()
        bot.shutdown()
    }
}