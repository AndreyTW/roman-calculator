package ru.andreyTw.romanCalculator.telegram

class Dispatcher(
    private val botWrapper: BotWrapper,
    private val outputAppender: OutputAppender
) {

    fun shutdown() {
        outputAppender.out("Bot is shutting down...")
        botWrapper.shutdown()
    }
}