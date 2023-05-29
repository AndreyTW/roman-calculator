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

val dispatcher = Dispatcher(telegramBotWrapper, { println(it) })

fun main() {
    println("Application is starting!")
    init()
    Signal.handle(Signal("INT")) {
        dispatcher.shutdown()
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
