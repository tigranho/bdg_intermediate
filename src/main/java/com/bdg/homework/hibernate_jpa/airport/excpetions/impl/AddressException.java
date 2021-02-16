package com.bdg.homework.hibernate_jpa.airport.excpetions.impl;

import com.bdg.homework.hibernate_jpa.airport.enums.ErrorCode;
import com.bdg.homework.hibernate_jpa.airport.excpetions.ServiceException;

public class AddressException extends ServiceException {

    public AddressException(ErrorCode errorCode) {
        super(errorCode);
    }
}
