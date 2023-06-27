package ru.andreyTw.romanCalculator.telegram

class Dispatcher(
    private val botWrapper: BotWrapper,
    private val outputAppender: (data: String) -> Unit,
    private val exitProcess: (signal: Int) -> Unit
) {

    private fun init() {
        outputAppender("Bot is initializing...")
        botWrapper.init()
    }

    private fun shutdown() {
        outputAppender("Bot is shutting down...")
        botWrapper.shutdown()
    }

    fun executeStartSequence(
        message: String
    ) {
        outputAppender(message)
        init()
    }

    fun handleIntSignal(
        message: String,
        exitCode: Int
    ) {
        outputAppender(message)
        shutdown()
        exitProcess(exitCode)
    }
}
