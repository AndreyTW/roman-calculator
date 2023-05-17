package ru.andreyTw.romanCalculator.telegram

import com.pengrad.telegrambot.UpdatesListener.CONFIRMED_UPDATES_ALL
import com.pengrad.telegrambot.model.Chat
import com.pengrad.telegrambot.model.Message
import com.pengrad.telegrambot.model.Update
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.verify

@ExtendWith(MockitoExtension::class)
class CustomUpdateListenerShould {

    @Mock
    private lateinit var botWrapper: BotWrapper

    @Mock
    private lateinit var update: Update

    @Mock
    private lateinit var message: Message

    @Mock
    private lateinit var chat: Chat

    @Test
    fun processSuccessfully() {
        val updates = listOf(update)

        `when`(message.text()).thenReturn("-")
        `when`(message.chat()).thenReturn(chat)
        `when`(chat.id()).thenReturn(1)
        `when`(update.message()).thenReturn(message)
        val actual = CustomUpdateListener(botWrapper).process(updates)

        verify(botWrapper).sendMessage("1", "-")
        assertEquals(CONFIRMED_UPDATES_ALL, actual)
    }
}