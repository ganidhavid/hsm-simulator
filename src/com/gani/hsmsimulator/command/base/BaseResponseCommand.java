package com.gani.hsmsimulator.command.base;

import org.beanio.annotation.Field;
import org.beanio.annotation.Record;

@Record
public class BaseResponseCommand {

    @Field(ordinal = 0, length = 2)
    private String responseCode;

    @Field(ordinal = 1, length = 2)
    private String errorCode;

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
}
