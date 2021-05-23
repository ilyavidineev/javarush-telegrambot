package com.github.ilyavidineev.jrtb;

import com.github.ilyavidineev.jrtb.command.Command;
import com.github.ilyavidineev.jrtb.command.CommandContainer;
import com.github.ilyavidineev.jrtb.command.CommandName;
import com.github.ilyavidineev.jrtb.command.UnknownCommand;
import com.github.ilyavidineev.jrtb.service.SendBotMessageService;
import com.github.ilyavidineev.jrtb.service.TelegramUserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

@DisplayName("Unit-level testing for CommandContainer")
public class CommandContainerTest {

    private CommandContainer commandContainer;

    @BeforeEach
    public void init() {
        SendBotMessageService sendBotMessageService = Mockito.mock(SendBotMessageService.class);
        TelegramUserService telegramUserService = Mockito.mock(TelegramUserService.class);
        commandContainer = new CommandContainer(sendBotMessageService, telegramUserService);
    }

    @Test
    public void shouldGetAllTheExistingCommands() {
        //when-then
        Arrays.stream(CommandName.values())
                .forEach(CommandName -> {
                    Command command = commandContainer.retrieveCommand(CommandName.getCommandName());
                    Assertions.assertNotEquals(UnknownCommand.class, command.getClass());
                });
    }

    @Test
    public void shouldReturnUnknownCommand() {
//        given
        String unknownCommand = "/fgfgfgfg";

        //when
        Command command = commandContainer.retrieveCommand(unknownCommand);

        //then
        Assertions.assertEquals(UnknownCommand.class, command.getClass());
    }

}
