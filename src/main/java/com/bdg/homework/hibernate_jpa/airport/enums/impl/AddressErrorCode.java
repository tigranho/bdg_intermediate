package com.bdg.homework.hibernate_jpa.airport.enums.impl;

import com.bdg.homework.hibernate_jpa.airport.constant.Message;
import com.bdg.homework.hibernate_jpa.airport.enums.ErrorCode;

public enum AddressErrorCode implements ErrorCode {

    ADDRESS_NOT_VALID_ID(Message.NOT_VALID_ID),
    ADDRESS_NOT_FOUND(Message.ADDRESS_NOT_FOUND),
    ADDRESS_IS_EMPTY(Message.INVALID_ADDRESS);


    private String message;

    AddressErrorCode(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
