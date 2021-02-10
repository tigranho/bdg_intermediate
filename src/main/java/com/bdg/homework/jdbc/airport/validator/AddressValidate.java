package com.bdg.homework.jdbc.airport.validator;

import com.bdg.homework.jdbc.airport.model.Address;

public class AddressValidate {

    private static boolean validate(final String value) {
        return value == null || value.equals(" ");
    }

    public static boolean checkFields(final Address address) {
        if (validate(address.getCity()) || validate(address.getCountry())) {
            return true;
        }
        return false;
    }

}
