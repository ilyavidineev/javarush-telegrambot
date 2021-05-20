package com.github.ilyavidineev.jrtb;

import com.github.ilyavidineev.jrtb.command.Command;
import com.github.ilyavidineev.jrtb.command.UnknownCommand;
import org.junit.jupiter.api.DisplayName;

import static com.github.ilyavidineev.jrtb.command.UnknownCommand.UNKNOWN_MESSAGE;

@DisplayName("Unit-level testing for UnknownCommand")
public class UnknownCommandTest extends AbstractCommandTest {

    @Override
    String getCommandName() {
        return "/fdgdfgdfgdbd";
    }

    @Override
    String getCommandMessage() {
        return UNKNOWN_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new UnknownCommand(sendBotMessageService);
    }
}