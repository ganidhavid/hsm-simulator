package com.gani.hsmsimulator.controller;

import com.gani.hsmsimulator.command.RequestCommand;
import com.gani.hsmsimulator.command.base.BaseRequestCommand;
import com.gani.hsmsimulator.util.FixedLengthUtil;

public class CommandController {
    public static String processRequest(String command) {
        Class aClass = null;
        RequestCommand requestCommand = null;
        BaseRequestCommand baseRequestCommand = null;
        String response = "";

        try {
            requestCommand = FixedLengthUtil.unmarshal(command, RequestCommand.class);
            aClass = Class.forName("com.gani.hsmsimulator.command." + requestCommand.getCommand());
            baseRequestCommand = (BaseRequestCommand) FixedLengthUtil.unmarshal(command, aClass);
            response = baseRequestCommand.performCommand();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }

        return response;
    }
}
