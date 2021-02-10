package com.bdg.homework.jdbc.airport.validator;

import com.bdg.homework.jdbc.airport.model.Company;

public class CompanyValidate {


    private CompanyValidate() {


    }


    private static boolean validate(final String value) {
        return value == null || value.equals(" ");
    }

    public static boolean checkFields(final Company company) {
        if (validate(company.getName()) || validate(company.getFoundingDate().toString())) {
            return true;
        }
        return false;
    }
}
