package com.bdg.homework.traveling.controller;

import com.bdg.homework.traveling.dataObjAc.daoImpl.TripDaoImpl;
import com.bdg.homework.traveling.dataObjAc.daoInterfaces.TripDao;
import com.bdg.homework.traveling.model.Trip;

import java.sql.Date;

public class TripController {

    static final TripDao tripDao=new TripDaoImpl();

    public static void main(String[] args) {
        Trip trip = new Trip(12524,new Date(2020,5,5),new Date(2020,5,5),"Yerevan","NewYork");
        tripDao.save(trip);



    }
}
