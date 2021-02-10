package com.bdg.homework.jdbc.airport.validator;

import com.bdg.homework.jdbc.airport.model.Passenger;

public class PassengerValidate {

    public PassengerValidate() {

    }


    private static boolean validate(final String value) {
        return value == null || value.equals(" ");
    }

    public boolean checkFields(final Passenger passenger) {
        if (validate(passenger.getName()) || validate(passenger.getPhone())) {
            return true;
        }
        return false;
    }
}
