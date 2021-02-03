package com.bdg;

import com.bdg.homework.airport.model.Address;
import com.bdg.homework.airport.model.Company;
import com.bdg.homework.airport.repository.*;

import java.time.LocalDateTime;
import java.time.Month;

/**
 * @author Aram
 */
public class Main {

    public static void main(String[] args) {
        CompanyDao dao= new CompanyDaoImpl();
        Company company=new Company("sevans-travel", LocalDateTime.of(2020, Month.JANUARY,23,11,24));
        System.out.println(dao.save(company));
        System.out.println(dao.getAll());




    }


}
