package com.gani.hsmsimulator.command;

import com.gani.hsmsimulator.command.base.BaseRequestCommand;
import com.gani.hsmsimulator.util.FixedLengthUtil;
import org.beanio.annotation.Record;

@Record
public class NC extends BaseRequestCommand {

    @Override
    public String performCommand() {
        ND response = new ND();
        response.setErrorCode("00");
        response.setLmkCheck("1234567890123456");
        response.setFirmwareNumber("XXXX-YYYY");

        return FixedLengthUtil.marshal(response);
    }
}
