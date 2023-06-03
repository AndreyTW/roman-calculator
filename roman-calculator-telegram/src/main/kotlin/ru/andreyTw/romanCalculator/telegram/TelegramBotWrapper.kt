package ru.andreyTw.romanCalculator.telegram

import com.pengrad.telegrambot.TelegramBot
import com.pengrad.telegrambot.request.SendMessage

// TODO add tests for class methods
class TelegramBotWrapper private constructor(
    key: String,
    private val ownerId: String,
    processor: (message: String) -> String
) : BotWrapper {
    private val bot: TelegramBot = TelegramBot(key)
    private val customUpdateListener = CustomUpdateListener(this, processor)

    override fun init() {
        bot.setUpdatesListener(customUpdateListener)
        sendMessage(ownerId, "Calculator enabled!")
    }

    override fun sendMessage(chatId: String, message: String) {
        bot.execute(SendMessage(chatId, message))
    }

    override fun shutdown() {
        sendMessage(ownerId, "Calculator disabled!")
        bot.removeGetUpdatesListener()
        bot.shutdown()
    }

    companion object {
        private var uniqueTelegramBotWrapperInstance: TelegramBotWrapper? = null

        fun getTelegramBotWrapper(
            key: String,
            ownerId: String,
            processor: (message: String) -> String
        ): TelegramBotWrapper {
            when (uniqueTelegramBotWrapperInstance) {
                null -> {
                    uniqueTelegramBotWrapperInstance = TelegramBotWrapper(key, ownerId, processor)
                }
            }
            return uniqueTelegramBotWrapperInstance!!
        }
    }
}