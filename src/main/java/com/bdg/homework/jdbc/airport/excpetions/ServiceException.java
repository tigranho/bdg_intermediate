package com.bdg.homework.jdbc.airport.excpetions;

import com.bdg.homework.jdbc.airport.enums.ErrorCode;

public abstract class ServiceException extends Exception {

    private String message;


    public ServiceException(ErrorCode errorCode) {
        this.message = errorCode.getMessage();
    }


    public String getMessage() {
        return message;
    }
}
