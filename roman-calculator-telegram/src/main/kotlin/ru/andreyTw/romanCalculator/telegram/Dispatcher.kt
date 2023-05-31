package ru.andreyTw.romanCalculator.telegram

import sun.misc.Signal
import kotlin.system.exitProcess

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

    fun executeStartSequence(
        message: String = "Default start message"
    ) {
        outputAppender(message)
        init()
    }

    fun handleIntSignal(
        message: String = "Default INT signal exit message",
        exitCode: Int = 0
    ) {
        Signal.handle(Signal("INT")) {
            outputAppender(message)
            shutdown()
            exitProcess(exitCode)
        }
    }
}
