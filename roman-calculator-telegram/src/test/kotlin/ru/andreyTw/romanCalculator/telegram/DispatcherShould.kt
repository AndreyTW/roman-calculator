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

    @BeforeEach
    fun setUp() {
        dispatcher = Dispatcher(botWrapper) { outputAppender(it) }
    }

    @Test
    fun initialize() {
        dispatcher.init()
        verify(botWrapper).init()
        verify(outputAppender).invoke(eq("Bot is initializing..."))
    }

    @Test
    fun shutdown() {
        dispatcher.shutdown()
        verify(botWrapper).shutdown()
        verify(outputAppender).invoke(eq("Bot is shutting down..."))
    }

    @Test
    fun executeStartSequence() {
        val testMessage = "Test message"
        dispatcher.executeStartSequence(testMessage)
        //TODO ???
        verify(botWrapper).init()
        verify(outputAppender).invoke(eq(testMessage))
    }

//    @Test
//    fun handleIntSignal() {
//        val testMessage = "Test message"
//        val testExitCode = 5
//        dispatcher.handleIntSignal(testMessage, testExitCode)
//        //TODO ???
//        verify(botWrapper).shutdown()
//        verify(outputAppender).invoke(eq(testMessage))
//    }

}

