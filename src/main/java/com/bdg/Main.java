package com.bdg;

import com.bdg.homework.airport.model.Company;
import com.bdg.homework.airport.model.Trip;
import com.bdg.homework.airport.repository.CompanyDao;
import com.bdg.homework.airport.repository.CompanyDaoImpl;
import com.bdg.homework.airport.repository.TripDao;
import com.bdg.homework.airport.repository.TripDaoImpl;

import java.time.LocalDateTime;
import java.time.Month;

/**
 * @author Aram
 */
public class Main {

    public static void main(String[] args) {
        TripDao tripDao = new TripDaoImpl();
        CompanyDao companyDao = new CompanyDaoImpl();
        Company company = companyDao.getById(2);
        Trip trip = new Trip(company, LocalDateTime.of(2020, Month.JUNE, 12, 15, 33), LocalDateTime.of(2021, Month.JUNE, 23, 12, 33), "cc", "dd");
        System.out.println(tripDao.save(trip));


    }


}
