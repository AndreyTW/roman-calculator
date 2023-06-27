package ru.andreyTw.romanCalculator.telegram

import ru.andreyTw.romanCalculator.core.InputExpressionProcessor
import ru.andreyTw.romanCalculator.telegram.TelegramBotWrapper.Companion.getTelegramBotWrapper
import sun.misc.Signal
import java.io.File
import kotlin.system.exitProcess

fun main() {
    val telegramBotWrapper: BotWrapper = getTelegramBotWrapper(
        File("roman-calculator-telegram/src/test/resources/botKey").readText(),
        File("roman-calculator-telegram/src/test/resources/botOwnerId").readText(),
        InputExpressionProcessor::processExpression
    )

    val dispatcher = Dispatcher(telegramBotWrapper, { println(it) }, { exitProcess(it) })

    dispatcher.executeStartSequence("Application is starting!")

    Signal.handle(Signal("INT")) {
        dispatcher.handleIntSignal("Application is closing!", 0)
    }

    while (true) {
    }
}
