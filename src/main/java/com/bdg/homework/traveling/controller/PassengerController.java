package com.bdg.homework.traveling.controller;

import com.bdg.homework.traveling.dataObjAc.daoImpl.PassengersDaoImpl;
import com.bdg.homework.traveling.dataObjAc.daoInterfaces.PassengersDao;
import com.bdg.homework.traveling.model.Passenger;

public class PassengerController {
    static final PassengersDao passengersDao = new PassengersDaoImpl();

    public static void main(String[] args) {

        Passenger passenger = new Passenger("Arsen",52525252);
        Passenger passenger2 = new Passenger("Arsen",11111111);
        Passenger passenger1=  passengersDao.save(passenger);
        System.out.println(passenger1);
        passengersDao.update(passenger2,1);

    }
}
