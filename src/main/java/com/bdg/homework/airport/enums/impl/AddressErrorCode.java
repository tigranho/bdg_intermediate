package com.bdg.homework.airport.enums.impl;

import com.bdg.homework.airport.constant.Message;
import com.bdg.homework.airport.enums.ErrorCode;

public enum AddressErrorCode implements ErrorCode {

    ADDRESS_NOT_VALID_ID(Message.NOT_VALID_ID),
    ADDRESS_NOT_FOUND(Message.ADDRESS_NOT_FOUND);


    private String message;

    AddressErrorCode(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
