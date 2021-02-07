package com.bdg.ams.systemmenegment;

import com.bdg.ams.service.FillDataService;

public class FillPassengerData {

    final  FillDataService dataService;

    public FillPassengerData() {
        this.dataService = new FillDataService();
    }

    public static void main(String[] args) {
        new FillPassengerData().dataService.fillPassengerData();

    }
}
