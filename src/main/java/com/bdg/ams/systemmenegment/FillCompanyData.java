package com.bdg.ams.systemmenegment;

import com.bdg.ams.service.FillDataService;

public class FillCompanyData {

    final FillDataService dataService;

    public FillCompanyData() {
        this.dataService = new FillDataService();
    }

    public static void main(String[] args) {

        new FillCompanyData().dataService.fillCompanyData();
    }
}
