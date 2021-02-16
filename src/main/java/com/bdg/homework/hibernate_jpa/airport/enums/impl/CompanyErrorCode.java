package com.bdg.homework.hibernate_jpa.airport.enums.impl;

import com.bdg.homework.hibernate_jpa.airport.constant.Message;
import com.bdg.homework.hibernate_jpa.airport.enums.ErrorCode;

public enum CompanyErrorCode implements ErrorCode {

    COMPANY_NOT_VALID_ID(Message.NOT_VALID_ID),
    COMPANY_NOT_FOUND(Message.COMPANY_NOT_FOUND),
    COMPANY_IS_EMPTY(Message.INVALID_COMPANY),
    COMPANY_SAVE(Message.SAVE_COMPANY);


    private final String message;

    CompanyErrorCode(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
