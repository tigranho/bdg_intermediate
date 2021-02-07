package com.bdg;

import com.bdg.homework.airport.model.Passenger;
import com.bdg.homework.airport.repository.PassengerDao;
import com.bdg.homework.airport.repository.PassengerDaoImpl;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author Aram
 */
public class Main {

    public static void main(String[] args) {
        PassengerDao dao= new PassengerDaoImpl();
        Set<Passenger> passengers = dao.get(    1, 10, "asc");
        passengers.forEach((el)->{
            System.out.println(el);
        });


    }


}
