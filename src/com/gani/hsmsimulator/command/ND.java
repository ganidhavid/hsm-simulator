package com.gani.hsmsimulator.command;

import org.beanio.annotation.Field;
import org.beanio.annotation.Record;

@Record
public class ND {
    @Field(at = 1, length = 2)
    private String responseCode;

    @Field(at = 2, length = 2)
    private String errorCode;

    @Field(at = 3, length = 16)
    private String lmkCheck;

    @Field(at = 4, length = 9)
    private String firmwareNumber;

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

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
