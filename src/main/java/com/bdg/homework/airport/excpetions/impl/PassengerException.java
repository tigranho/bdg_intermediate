package com.bdg.homework.airport.excpetions.impl;

import com.bdg.homework.airport.enums.ErrorCode;
import com.bdg.homework.airport.excpetions.ServiceException;

public class PassengerException extends ServiceException {


    public PassengerException(ErrorCode errorCode) {
        super(errorCode);
    }
}
