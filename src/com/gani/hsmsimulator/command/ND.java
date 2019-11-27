package com.gani.hsmsimulator.command;

import com.gani.hsmsimulator.command.base.BaseResponseCommand;
import org.beanio.annotation.Field;
import org.beanio.annotation.Record;

@Record
public class ND extends BaseResponseCommand {
    public ND() {
        this.setResponseCode("ND");
    }

    @Field(ordinal = 2, length = 16)
    private String lmkCheck;

    @Field(ordinal = 3, length = 9)
    private String firmwareNumber;

    public String getLmkCheck() {
        return lmkCheck;
    }

    public void setLmkCheck(String lmkCheck) {
        this.lmkCheck = lmkCheck;
    }

    public String getFirmwareNumber() {
        return firmwareNumber;
    }

    public void setFirmwareNumber(String firmwareNumber) {
        this.firmwareNumber = firmwareNumber;
    }
}
