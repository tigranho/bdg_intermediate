package com.bdg.homework.jdbc.airport.enums.impl;

import com.bdg.homework.jdbc.airport.constant.Message;
import com.bdg.homework.jdbc.airport.enums.ErrorCode;

public enum PassengerErrorCode implements ErrorCode {

    PASSENGER_IS_EMPTY(Message.INVALID_PASSENGER),
    PASSENGER_NOT_VALID_ID(Message.NOT_VALID_ID),
    PASSENGER_NOT_FOUND(Message.PASSENGER_NOT_FOUND);
    ;


    private String message;

    PassengerErrorCode(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
