package ru.andreyTw.romanCalculator.telegram

import ru.andreyTw.romanCalculator.core.InputExpressionProcessor
import sun.misc.Signal
import java.io.File
import kotlin.system.exitProcess

val telegramBotWrapper: BotWrapper = TelegramBotWrapper(
    File("botKey").readText(),
    File("botOwnerId").readText(),
    InputExpressionProcessor::processExpression
)

fun main() {
    println("Application is starting!")
    init()
    Signal.handle(Signal("INT")) {
        shutdown()
        println("Application is closing!")
        exitProcess(0)
    }
    while (true) {
    }
}

private fun init() {
    println("Telegram bot is initializing...")

    telegramBotWrapper.init()
}

private fun shutdown() {
    println("Telegram bot is shutting down...")

    telegramBotWrapper.shutdown()
}
