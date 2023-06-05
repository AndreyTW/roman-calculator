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
    private var initFlag: Boolean = false

    override fun init() {
        when {
            !initFlag -> {
                bot.setUpdatesListener(customUpdateListener)
                sendMessage(ownerId, "Calculator enabled!")
                initFlag = true
            }
        }
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
        private var instances: MutableMap<String, TelegramBotWrapper> = HashMap()

        fun getTelegramBotWrapper(
            key: String,
            ownerId: String,
            processor: (message: String) -> String
        ): TelegramBotWrapper {
            if (!instances.containsKey(key)) {
                instances[key] = TelegramBotWrapper(key, ownerId, processor)
            }
            return instances[key]!!
        }
    }
}