package ru.andreyTw.romanCalculator.telegram

import com.pengrad.telegrambot.UpdatesListener
import com.pengrad.telegrambot.model.Update

class CustomUpdateListener(
    private val botWrapper: BotWrapper,
    private val handle: (String) -> String
) : UpdatesListener {

    override fun process(updates: List<Update>): Int {
        updates.forEach {
            val message = it.message().text()
            println("Expression \"$message\" was successfully received")
            botWrapper.sendMessage(it.message().chat().id().toString(), handle(message))
        }
        return UpdatesListener.CONFIRMED_UPDATES_ALL
    }
}
