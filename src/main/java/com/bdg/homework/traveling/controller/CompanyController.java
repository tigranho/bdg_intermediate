package com.bdg.homework.traveling.controller;

import com.bdg.homework.traveling.dataObjAc.daoImpl.CompanyDaoImpl;
import com.bdg.homework.traveling.dataObjAc.daoInterfaces.CompanyDao;
import com.bdg.homework.traveling.model.Company;
import com.bdg.homework.traveling.utils.CompanyFileReader;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public class CompanyController {

    static CompanyDao companyDao = new CompanyDaoImpl();
    public static void main(String[] args) {



        Company company = new Company("TRAVEL COMPANY",   new Date(2020,3,3));
        companyDao.save(company);

        Company company1 =  companyDao.getById(1);
        System.out.println( company1);
        Company company2= new Company("Autrian Airlens",new Date(2020,3,5));

        companyDao.delete(1);
        companyDao.update( company2,3);
        Set<Company> currentList=companyDao.getAll();
        System.out.print(currentList);
	
	
		//CompanyFileReader.readListOfCompany("src/main/java/com/bdg/homework/traveling/utils/res/companies.txt");


    }
}
