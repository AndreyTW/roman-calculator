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
    private lateinit var outputAppender: (data: String) -> Unit

    @Mock
    private lateinit var exitProcess: (signal: Int) -> Unit

    @BeforeEach
    fun setUp() {
        dispatcher = Dispatcher(botWrapper, { outputAppender(it) }, { exitProcess(it) })
    }

    @Test
    fun executeStartSequence() {
        dispatcher.executeStartSequence("message")

        verify(botWrapper).init()
        verify(outputAppender).invoke(eq("Bot is initializing..."))
        verify(outputAppender).invoke(eq("message"))
    }

    @Test
    fun handleIntSignal() {
        dispatcher.handleIntSignal("message", 0)

        verify(botWrapper).shutdown()
        verify(outputAppender).invoke(eq("Bot is shutting down..."))
        verify(outputAppender).invoke(eq("message"))
        verify(exitProcess).invoke(eq(0))

    }

}

