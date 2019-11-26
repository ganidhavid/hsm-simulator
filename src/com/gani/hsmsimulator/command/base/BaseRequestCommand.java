package com.gani.hsmsimulator.command.base;

import org.beanio.annotation.Field;
import org.beanio.annotation.Record;

@Record
public class BaseRequestCommand {

    @Field(at = 0, length = 2)
    private String command;

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }
}
