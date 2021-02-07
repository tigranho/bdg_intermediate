package com.bdg.ams.service;

import com.bdg.ams.exception.DatabaseException;
import com.bdg.ams.model.Company;
import com.bdg.ams.model.Passenger;
import com.bdg.ams.repo.dao.PassengerDao;
import com.bdg.ams.repo.dao.daoimpl.PassengerDaoImpl;

import java.util.Optional;

public class PassengerService {

    private final PassengerDao passengerDao;

    public PassengerService() {
        this.passengerDao = new PassengerDaoImpl();
    }


    public void companyById(long id) {
        try {
            Optional<Passenger> byId = passengerDao.getById(id);
            if (byId.isPresent()) {
                System.out.println(byId.get());

            } else {
                System.out.println("Passenger not found");

            }
        } catch (DatabaseException e) {
            e.printStackTrace();
        }
    }
}
