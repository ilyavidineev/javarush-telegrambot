package com.github.ilyavidineev.jrtb;

import com.github.ilyavidineev.jrtb.command.Command;
import com.github.ilyavidineev.jrtb.command.StartCommand;
import org.junit.jupiter.api.DisplayName;

import static com.github.ilyavidineev.jrtb.command.CommandName.START;
import static com.github.ilyavidineev.jrtb.command.StartCommand.START_MESSAGE;

@DisplayName("Unit-level testing for StartCommand")
class StartCommandTest extends AbstractCommandTest {

    @Override
    String getCommandName() {
        return START.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return START_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new StartCommand(sendBotMessageService);
    }
}