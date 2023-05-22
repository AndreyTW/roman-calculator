package ru.andreyTw.romanCalculator.telegram

import com.pengrad.telegrambot.TelegramBot
import com.pengrad.telegrambot.request.SendMessage


// TODO add tests for class methods
class TelegramBotWrapper(
    key: String,
    private val ownerId: String,
    processor: (message: String) -> String
) : BotWrapper {
    private val bot: TelegramBot = TelegramBot(key)
    private val customUpdateListener = CustomUpdateListener(this, processor)

    override fun init() {
        bot.setUpdatesListener(customUpdateListener)
        sendMessage(ownerId, "I'm ready!")
    }

    override fun sendMessage(chatId: String, message: String) {
        bot.execute(SendMessage(chatId, message))
    }

    override fun shutdown() {
        sendMessage(ownerId, "I'm going to die!")
        bot.removeGetUpdatesListener()
        bot.shutdown()
    }
}