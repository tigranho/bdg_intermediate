package com.bdg.ams.service;

import com.bdg.ams.exception.DatabaseException;
import com.bdg.ams.model.Address;
import com.bdg.ams.model.Company;
import com.bdg.ams.repo.dao.AddressDao;
import com.bdg.ams.repo.dao.daoimpl.AddressDaoImpl;

import java.util.Optional;

public class AddressService {

    private final AddressDao addressDao;

    public AddressService() {
        this.addressDao =new AddressDaoImpl();
    }


    public void addressById(long id) {
        try {
            Optional<Address> byId = addressDao.getById(id);
            if (byId.isPresent()) {
                System.out.println(byId.get());

            } else {
                System.out.println("Company not found");

            }
        } catch (DatabaseException e) {
            e.printStackTrace();
        }
    }
}
