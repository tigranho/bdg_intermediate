package com.bdg.homework.jdbc.airport.excpetions.impl;

import com.bdg.homework.jdbc.airport.enums.ErrorCode;
import com.bdg.homework.jdbc.airport.excpetions.ServiceException;

public class PassengerException extends ServiceException {


    public PassengerException(ErrorCode errorCode) {
        super(errorCode);
    }
}
