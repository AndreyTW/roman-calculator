package ru.andreyTw.romanCalculator.telegram

import com.pengrad.telegrambot.TelegramBot
import com.pengrad.telegrambot.UpdatesListener
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.BeforeEach
import ru.andreyTw.romanCalculator.telegram.TelegramBotWrapper.Companion.getTelegramBotWrapper

class TelegramBotWrapperShould {

    private lateinit var telegramBotWrapper: TelegramBotWrapper

    private var telegramBot: MockTelegramBot = MockTelegramBot()

    @BeforeEach
    fun setUp() {
        telegramBotWrapper = getTelegramBotWrapper("", "", { "" }, telegramBot)
    }

    //    @Test
    fun initializeBot() {
        telegramBotWrapper.init()
        assertNotNull(telegramBot.mockUpdateListener)

        telegramBotWrapper.shutdown()
        assertNull(telegramBot.mockUpdateListener)
    }

    class MockTelegramBot : TelegramBot("") {

        var mockUpdateListener: UpdatesListener? = null

        override fun setUpdatesListener(listener: UpdatesListener?) {
            mockUpdateListener = listener
            super.setUpdatesListener(listener)
        }

        override fun removeGetUpdatesListener() {
            mockUpdateListener = null
            super.removeGetUpdatesListener()
        }
    }
}