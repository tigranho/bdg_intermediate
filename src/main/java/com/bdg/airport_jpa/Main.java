package com.bdg.airport_jpa;

import com.bdg.airport_jpa.jpa_daoImpl.AddressDaoImpl;
import com.bdg.airport_jpa.jpa_daoImpl.PassengerDaoImpl;

public class Main {
    public static void main(String[] args) {
        AddressDaoImpl addressDao=new AddressDaoImpl();
        PassengerDaoImpl passengerDao=new PassengerDaoImpl();
       // addressDao.persist(new Address("Italy","Milan"));
//        Address address=addressDao.findById(2);
//        System.out.println(address.toString());
//         addressDao.delete(11);
//        addressDao.update(new Address("Russia","Moscow"),3);
//        List<Address>list=addressDao.findAll();
//        list.forEach(System.out::println);
//        Address address=new Address("Hungarya","Buxarest");
//        passengerDao.persist(new Passenger("Artur","094230081",address));
//          ReadFromFile readFromFile=new ReadFromFile();
//          readFromFile.addAddressToDb(ReadFromFile.readFile(ReadFromFile.PATH_PASSENGERS));
    }
}
