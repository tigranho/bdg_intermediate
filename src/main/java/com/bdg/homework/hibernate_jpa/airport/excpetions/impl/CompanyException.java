package com.bdg.homework.hibernate_jpa.airport.excpetions.impl;

import com.bdg.homework.hibernate_jpa.airport.enums.ErrorCode;
import com.bdg.homework.hibernate_jpa.airport.excpetions.ServiceException;

public class CompanyException extends ServiceException {
    public CompanyException(ErrorCode errorCode) {
        super(errorCode);
    }
}
