package com.gani.hsmsimulator.command.base;

import com.gani.hsmsimulator.constants.Command;
import org.beanio.annotation.Field;
import org.beanio.annotation.Record;

@Record
public class BaseResponseCommand {

    @Field(ordinal = 0, length = 2)
    private Command responseCode;

    @Field(ordinal = 1, length = 2)
    private String errorCode;

    public Command getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Command responseCode) {
        this.responseCode = responseCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
