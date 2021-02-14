package com.bdg.homework.traveling.controller;

import com.bdg.homework.traveling.dataObjAc.daoImpl.AddressDaoImpl;
import com.bdg.homework.traveling.dataObjAc.daoInterfaces.AddressDao;
import com.bdg.homework.traveling.model.Address;

public class AdressController {

    public static void main(String[] args) {
        AddressDao addressDao = new AddressDaoImpl();
        Address address = new Address("Armenia", "Yerevan");

        Address address1 = addressDao.saveAddress(address);
        System.out.println( "This is the result of saveAddress() "+address1 );


        Address findGivenAddress= addressDao.getById(1);
        System.out.println("This is the result of getById()"+ findGivenAddress);


    }


}
