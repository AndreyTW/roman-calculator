package ru.andreyTw.romanCalculator.telegram

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.eq
import org.mockito.kotlin.verify

@ExtendWith(MockitoExtension::class)
class DispatcherShould {

    private lateinit var dispatcher: Dispatcher

    @Mock
    private lateinit var botWrapper: BotWrapper

    @Mock
    private lateinit var outputAppender: OutputAppender

    @BeforeEach
    fun setUp() {
        dispatcher = Dispatcher(botWrapper, outputAppender)
    }

    @Test
    fun shutdown() {
        dispatcher.shutdown()
        verify(botWrapper).shutdown()
        verify(outputAppender).out(eq("Bot is shutting down..."))
    }

}

