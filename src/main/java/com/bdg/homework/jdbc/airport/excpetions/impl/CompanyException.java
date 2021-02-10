package com.bdg.homework.jdbc.airport.excpetions.impl;

import com.bdg.homework.jdbc.airport.enums.ErrorCode;
import com.bdg.homework.jdbc.airport.excpetions.ServiceException;

public class CompanyException extends ServiceException {
    public CompanyException(ErrorCode errorCode) {
        super(errorCode);
    }
}
