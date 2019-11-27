package com.gani.hsmsimulator.command.base;

import com.gani.hsmsimulator.constants.Command;
import com.gani.hsmsimulator.service.CommandHandler;
import org.beanio.annotation.Field;
import org.beanio.annotation.Record;

@Record
public abstract class BaseRequestCommand implements CommandHandler {

    @Field(ordinal = 0, length = 2)
    private Command command;

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }
}
