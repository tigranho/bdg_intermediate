package com.bdg.homework.hibernate_jpa.airport.controller;

import com.bdg.homework.hibernate_jpa.airport.enums.impl.PassengerErrorCode;
import com.bdg.homework.hibernate_jpa.airport.excpetions.impl.PassengerException;
import com.bdg.homework.hibernate_jpa.airport.model.Passenger;
import com.bdg.homework.hibernate_jpa.airport.service.AddressService;
import com.bdg.homework.hibernate_jpa.airport.service.PassengerService;
import com.bdg.homework.hibernate_jpa.airport.service.impl.AddressServiceImpl;
import com.bdg.homework.hibernate_jpa.airport.service.impl.PassengerServiceImpl;
import com.bdg.homework.hibernate_jpa.airport.validator.PassengerValidate;


public class PassengerController {

    private final PassengerService passengerService;
    private final AddressService addressService;
    private final PassengerValidate validator;

    public PassengerController() {
        passengerService = new PassengerServiceImpl();
        addressService = new AddressServiceImpl();
        validator = new PassengerValidate();
    }


    public void save(final Passenger passenger) throws PassengerException {
        if (validator.checkFields(passenger)) {
            throw new PassengerException(PassengerErrorCode.PASSENGER_IS_EMPTY);
        }
        passengerService.save(passenger);
    }


}
