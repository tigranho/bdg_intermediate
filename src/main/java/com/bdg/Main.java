package com.bdg;

import com.bdg.homework.airport.model.Address;
import com.bdg.homework.airport.repository.AddressDao;
import com.bdg.homework.airport.repository.AddressDaoImpl;
import com.bdg.homework.airport.repository.PassengerDao;
import com.bdg.homework.airport.repository.PassengerDaoImpl;

/**
 * @author Aram
 */
public class Main {

    public static void main(String[] args) {
     PassengerDao passengerDao = new PassengerDaoImpl();
//        System.out.println(passengerDto.getAll());
        AddressDao addressDao= new AddressDaoImpl();
        Address address= new Address("KIev","Ukrain");
//        System.out.println(addressDao.save(address));
//        Passenger passenger= new Passenger("Hov","36-14-38",address);
        passengerDao.delete(3);



    }


}
