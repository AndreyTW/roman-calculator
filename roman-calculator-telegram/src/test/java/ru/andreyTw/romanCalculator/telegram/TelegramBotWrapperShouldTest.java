package ru.andreyTw.romanCalculator.telegram;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TelegramBotWrapperShouldTest {

    private TelegramBotWrapper telegramBotWrapper;

    @Mock
    private TelegramBot telegramBot;

    @Mock
    private SendResponse response;

    public void setFinal(Field field, Object instance, Object value) throws Exception {
        final var unsafeField = Unsafe.class.getDeclaredField("theUnsafe");
        unsafeField.setAccessible(true);
        final var unsafe = (Unsafe) unsafeField.get(null);

        long fieldOffset = unsafe.objectFieldOffset(field);
        unsafe.putObject(instance, fieldOffset, value);

        unsafeField.setAccessible(false);
    }

    @BeforeEach
    public void setUp() throws Exception {
        telegramBotWrapper = TelegramBotWrapper.Companion.getTelegramBotWrapper("", "", s -> "");

        final var botField = telegramBotWrapper.getClass().getDeclaredField("bot");
        botField.setAccessible(true);
        setFinal(botField, telegramBotWrapper, telegramBot);
        botField.setAccessible(false);
    }


    @Test
    public void initializeBot() {
        when(telegramBot.execute(any(SendMessage.class))).thenReturn(response);

        telegramBotWrapper.init();

        verify(telegramBot).setUpdatesListener(any(UpdatesListener.class));
    }
}
