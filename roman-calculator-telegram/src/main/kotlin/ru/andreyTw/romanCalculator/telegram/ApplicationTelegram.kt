package ru.andreyTw.romanCalculator.telegram

import ru.andreyTw.romanCalculator.core.InputExpressionProcessor
import java.io.File

val telegramBotWrapper: BotWrapper = TelegramBotWrapper(
    File("roman-calculator-telegram/src/test/resources/botKey").readText(),
    File("roman-calculator-telegram/src/test/resources/botOwnerId").readText(),
    InputExpressionProcessor::processExpression
)

val dispatcher = Dispatcher(telegramBotWrapper) { println(it) }

fun main() {
    dispatcher.executeStartSequence("Application is starting!")
    dispatcher.handleIntSignal("Application is closing!")
    while (true) {
    }
}
