package ru.andreyTw.romanCalculator.telegram

class Dispatcher(
    private val botWrapper: BotWrapper,
    private val outputAppender: (data: String) -> Unit
) {

    fun init() {
        outputAppender("Bot is initializing...")
        botWrapper.init()
    }

    fun shutdown() {
        outputAppender("Bot is shutting down...")
        botWrapper.shutdown()
    }
}
