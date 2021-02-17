package com.bdg;

import com.bdg.homework.hibernate_jpa.airport.model.Address;
import com.bdg.homework.hibernate_jpa.airport.repository.AddressDao;
import com.bdg.homework.hibernate_jpa.airport.repository.impl.AddressDaoImpl;

/**
 * @author Aram
 */
public class Main {

    private String test;

    public static void main(String[] args) {
        Address address = new Address("Yerevan", "Armenia");
        AddressDao addressDao = new AddressDaoImpl();
         addressDao.delete(4);


    }


}
