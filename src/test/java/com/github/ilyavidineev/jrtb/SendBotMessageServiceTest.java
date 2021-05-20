package com.github.ilyavidineev.jrtb;

import com.github.ilyavidineev.jrtb.bot.JavarushTelegramBot;
import com.github.ilyavidineev.jrtb.service.SendBotMessageService;
import com.github.ilyavidineev.jrtb.service.SendBotMessageServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@DisplayName("Unit-level testing for SendBotMessageService")
public class SendBotMessageServiceTest {

    private SendBotMessageService sendBotMessageService;
    private JavarushTelegramBot javarushTelegramBot;

    @BeforeEach
    public void init() {
        javarushTelegramBot = Mockito.mock(JavarushTelegramBot.class);
        sendBotMessageService = new SendBotMessageServiceImpl(javarushTelegramBot);
    }

    @Test
    public void shouldProperlySendMessage() throws TelegramApiException {
//        given
        String chatId = "test_chat_id";
        String message = "test_message";

        SendMessage sm = new SendMessage();
        sm.setText(message);
        sm.setChatId(chatId);
        sm.enableHtml(true);

//        when
        sendBotMessageService.sendMessage(chatId, message);

//        then
        Mockito.verify(javarushTelegramBot).execute(sm);


    }


}
