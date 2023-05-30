package ru.andreyTw.romanCalculator.telegram

import ru.andreyTw.romanCalculator.core.InputExpressionProcessor
import sun.misc.Signal
import java.io.File
import kotlin.system.exitProcess

val telegramBotWrapper: BotWrapper = TelegramBotWrapper(
    File("roman-calculator-telegram/src/test/resources/botKey").readText(),
    File("roman-calculator-telegram/src/test/resources/botOwnerId").readText(),
    InputExpressionProcessor::processExpression
)

val dispatcher = Dispatcher(telegramBotWrapper, { println(it) })

fun main() {
    println("Application is starting!")
    dispatcher.init()
    Signal.handle(Signal("INT")) {
        println("Application is closing!")
        dispatcher.shutdown()
        exitProcess(0)
    }
    while (true) {
    }
}
