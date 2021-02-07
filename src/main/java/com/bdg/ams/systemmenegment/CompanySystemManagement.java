package com.bdg.ams.systemmenegment;

import com.bdg.ams.service.CompanyService;

public class CompanySystemManagement {


    final CompanyService companyService;

    public CompanySystemManagement() {
        this.companyService = new CompanyService();
    }

    public static void main(String[] args) {
        CompanySystemManagement asm = new CompanySystemManagement();
        //    asm.companyService.allCompany();


    }
}
