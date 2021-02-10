package com.bdg.homework.jdbc.airport.excpetions.impl;

import com.bdg.homework.jdbc.airport.enums.ErrorCode;
import com.bdg.homework.jdbc.airport.excpetions.ServiceException;

public class AddressException extends ServiceException {

    public AddressException(ErrorCode errorCode) {
        super(errorCode);
    }
}
