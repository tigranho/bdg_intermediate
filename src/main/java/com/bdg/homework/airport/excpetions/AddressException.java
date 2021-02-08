package com.bdg.homework.airport.excpetions;

import com.bdg.homework.airport.enums.ErrorCode;

public class AddressException extends ServiceException {

    public AddressException(ErrorCode errorCode) {
        super(errorCode);
    }
}
