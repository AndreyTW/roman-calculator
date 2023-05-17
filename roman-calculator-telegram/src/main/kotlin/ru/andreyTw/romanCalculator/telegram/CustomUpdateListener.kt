package ru.andreyTw.romanCalculator.telegram

import com.pengrad.telegrambot.UpdatesListener
import com.pengrad.telegrambot.model.Update

class CustomUpdateListener(private val botWrapper: BotWrapper) : UpdatesListener {

    override fun process(updates: List<Update>): Int {
        updates.forEach {
            val message = it.message().text()
            println("Expression \"$message\" was successfully received")
//            val result = InputExpressionProcessor.processExpression(message)
            botWrapper.sendMessage(it.message().chat().id().toString(), message)
        }
        return UpdatesListener.CONFIRMED_UPDATES_ALL
    }

    /*  override fun init() {
          bot.setUpdatesListener { updates ->
              updates.forEach {
                  val result = InputExpressionProcessor.processExpression(message)
                  bot.execute(SendMessage(it.message().chat().id(), result))
              }
              UpdatesListener.CONFIRMED_UPDATES_ALL
          }*/

}
