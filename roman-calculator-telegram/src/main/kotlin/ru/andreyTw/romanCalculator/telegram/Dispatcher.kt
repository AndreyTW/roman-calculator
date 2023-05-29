package ru.andreyTw.romanCalculator.telegram

class Dispatcher(
    private val botWrapper: BotWrapper,
    private val outputAppender: (data: String) -> Unit
) {

    fun shutdown() {
        outputAppender("Bot is shutting down...")
        botWrapper.shutdown()
    }
}
