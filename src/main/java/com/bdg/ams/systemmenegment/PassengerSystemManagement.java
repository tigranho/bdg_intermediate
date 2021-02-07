package com.bdg.ams.systemmenegment;

import com.bdg.ams.service.PassengerService;

public class PassengerSystemManagement {

    private final PassengerService passengerService;


    public PassengerSystemManagement() {
        this.passengerService = new PassengerService();
    }

    public static void main(String[] args) {
        PassengerSystemManagement psm = new PassengerSystemManagement();
        psm.passengerService.companyById(1);
    }
}
