package ru.andreyTw.romanCalculator.telegram

import com.pengrad.telegrambot.TelegramBot
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.any
import org.mockito.kotlin.verify
import ru.andreyTw.romanCalculator.telegram.TelegramBotWrapper.Companion.getTelegramBotWrapper
import java.lang.reflect.Field
import java.lang.reflect.Modifier

@ExtendWith(MockitoExtension::class)
class TelegramBotWrapperShould {

    private lateinit var telegramBotWrapper: TelegramBotWrapper

    @Mock
    private lateinit var telegramBot: TelegramBot

    @BeforeEach
    fun setUp() {
        //
        telegramBotWrapper = getTelegramBotWrapper("", "") { "" }
        val botField = telegramBot.javaClass.getDeclaredField("api")
        botField.isAccessible = true
        val modifiers = Field::class.java.getDeclaredField("modifiers")
        modifiers.isAccessible = true
        modifiers.setInt(botField, botField.modifiers.and(Modifier.FINAL.inv()))






        botField.set(telegramBotWrapper, telegramBot)
        botField.isAccessible = false
    }


    @Test
    fun initializeBot() {
        telegramBotWrapper.init()
        verify(telegramBot.setUpdatesListener(any()))
    }

    @Test
    fun sendMessageFromBot() {
//        telegramBotWrapper.sendMessage()

    }

    @Test
    fun shutdownBot() {
//        telegramBotWrapper.shutdown()

    }
}