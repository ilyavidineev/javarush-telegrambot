package com.github.ilyavidineev.jrtb;

import com.github.ilyavidineev.jrtb.command.Command;
import com.github.ilyavidineev.jrtb.command.StopCommand;
import org.junit.jupiter.api.DisplayName;

import static com.github.ilyavidineev.jrtb.command.CommandName.STOP;
import static com.github.ilyavidineev.jrtb.command.StopCommand.STOP_MESSAGE;

@DisplayName("Unit-level testing for StopCommand")
public class StopCommandTest extends AbstractCommandTest {

    @Override
    String getCommandName() {
        return STOP.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return STOP_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new StopCommand(sendBotMessageService);
    }
}