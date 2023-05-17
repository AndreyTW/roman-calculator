package ru.andreyTw.romanCalculator.telegram

interface BotWrapper {
    fun init()

    fun sendMessage(chatId: String, message: String)

    fun shutdown()
}