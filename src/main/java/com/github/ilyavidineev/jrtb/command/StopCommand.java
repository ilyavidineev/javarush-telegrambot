package com.github.ilyavidineev.jrtb.command;

import com.github.ilyavidineev.jrtb.service.SendBotMessageService;
import com.github.ilyavidineev.jrtb.service.TelegramUserService;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * Stop {@link Command}.
 */
public class StopCommand implements Command {

    private final SendBotMessageService sendBotMessageService;
    private final TelegramUserService telegramUserService;

    public static final String STOP_MESSAGE = "Деактивировал все ваши подписки \uD83D\uDE1F.";

    public StopCommand(SendBotMessageService sendBotMessageService, TelegramUserService telegramUserService) {
        this.sendBotMessageService = sendBotMessageService;
        this.telegramUserService = telegramUserService;
    }

    @Override
    public void execute(Update update) {
        String chatId = update.getMessage().getChatId().toString();
        telegramUserService.findByChatId(chatId)
                .ifPresent(user -> {
                    user.setActive(false);
                    telegramUserService.save(user);
                });
        sendBotMessageService.sendMessage(chatId, STOP_MESSAGE);
    }
}