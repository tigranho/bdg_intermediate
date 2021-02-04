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
       TripDao tripDao= new TripDaoImpl();
        System.out.println(tripDao.getById(1));


    }


}
