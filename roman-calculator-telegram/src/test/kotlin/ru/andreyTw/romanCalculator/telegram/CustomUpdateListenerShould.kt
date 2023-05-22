package ru.andreyTw.romanCalculator.telegram

import com.pengrad.telegrambot.UpdatesListener
import com.pengrad.telegrambot.UpdatesListener.CONFIRMED_UPDATES_ALL
import com.pengrad.telegrambot.model.Chat
import com.pengrad.telegrambot.model.Message
import com.pengrad.telegrambot.model.Update
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.verify

/** TODO
 * Add test for exception processing
 */
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


    private lateinit var customUpdateListener: UpdatesListener

    @BeforeEach
    fun setUp() {
        val emptyProcess = { message: String -> message }
        customUpdateListener = CustomUpdateListener(botWrapper, emptyProcess)
    }

    @Test
    fun processSuccessfully() {
        val updates = listOf(update)
        val messageText = "-"
        val userId: Long = 1

        buildInputMessage(messageText, userId)
        val actual = customUpdateListener.process(updates)

        verify(botWrapper).sendMessage("$userId", messageText)
        assertEquals(CONFIRMED_UPDATES_ALL, actual)
    }

    private fun buildInputMessage(messageText: String, userId: Long) {
        `when`(message.text()).thenReturn(messageText)
        `when`(message.chat()).thenReturn(chat)
        `when`(chat.id()).thenReturn(userId)
        `when`(update.message()).thenReturn(message)
    }
}