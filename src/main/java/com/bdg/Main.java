package com.bdg;

import com.bdg.homework.hibernate_jpa.airport.excpetions.impl.AddressException;
import com.bdg.homework.hibernate_jpa.airport.model.Address;
import com.bdg.homework.hibernate_jpa.airport.repository.AddressDao;
import com.bdg.homework.hibernate_jpa.airport.repository.impl.AddressDaoImpl;
import com.bdg.homework.hibernate_jpa.airport.service.AddressService;
import com.bdg.homework.hibernate_jpa.airport.service.impl.AddressServiceImpl;

/**
 * @author Aram
 */
public class Main {

    private String test;

    public static void main(String[] args) {
        Address address = new Address("Yerevan", " ");
        AddressService addressService= new AddressServiceImpl();
        try {
            addressService.save(address);
        } catch (AddressException e) {
           System.err.println(e);
           System.out.println(e);
        }


    }


}
