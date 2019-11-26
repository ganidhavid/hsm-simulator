package com.gani.hsmsimulator.controller;

import com.gani.hsmsimulator.command.NC;
import com.gani.hsmsimulator.command.ND;
import com.gani.hsmsimulator.command.base.BaseRequestCommand;
import com.gani.hsmsimulator.util.BeanIOUtilFactory;
import org.beanio.Marshaller;
import org.beanio.Unmarshaller;

public class CommandController {
    public static String processRequest(String command) {

        Unmarshaller unmarshaller = BeanIOUtilFactory.getUnmarshaller(BaseRequestCommand.class);

        BaseRequestCommand requestCommand = (BaseRequestCommand) unmarshaller.unmarshal(command);

        ND nd = new ND();
        nd.setResponseCode("ND");
        nd.setErrorCode("00");
        nd.setLmkCheck("1234567890123456");
        nd.setFirmwareNumber("XXXX-YYYY");

        Marshaller marshaller = BeanIOUtilFactory.getMarshaller(ND.class);

        String response = marshaller.marshal(nd).toString();
        return response;
    }
}
