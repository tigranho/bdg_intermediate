package com.bdg;

import com.bdg.homework.hibernate_jpa.airport.configuration.HibernateUtil;
import com.bdg.homework.hibernate_jpa.airport.model.Address;
import com.bdg.homework.hibernate_jpa.airport.model.Passenger;
import com.bdg.homework.hibernate_jpa.airport.repository.AddressDao;
import com.bdg.homework.hibernate_jpa.airport.repository.impl.AddressDaoImpl;


import javax.persistence.EntityManager;

/**
 * @author Aram
 */
public class Main {

    private String test;

    public static void main(String[] args) {
        Address address= new Address("Yerevan","Armenia");
        AddressDao addressDao= new AddressDaoImpl();
        Address save = addressDao.save(address);
        System.out.println(save.getId());


    }


}
