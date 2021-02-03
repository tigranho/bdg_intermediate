package com.bdg;

import com.bdg.homework.airport.configuration.DbConnection;
import com.bdg.homework.airport.model.Address;
import com.bdg.homework.airport.model.Passenger;
import com.bdg.homework.airport.repository.AddressDao;
import com.bdg.homework.airport.repository.AddressDaoImpl;
import com.bdg.homework.airport.repository.PassengerDto;
import com.bdg.homework.airport.repository.PassengerDtoImpl;

import java.sql.Connection;

/**
 * @author Aram
 */
public class Main {

    public static void main(String[] args) {
     PassengerDto passengerDto= new PassengerDtoImpl();
//        System.out.println(passengerDto.getAll());
        AddressDao addressDao= new AddressDaoImpl();
        Address address= new Address("KIev","Ukrain");
//        System.out.println(addressDao.save(address));
//        Passenger passenger= new Passenger("Hov","36-14-38",address);
        passengerDto.delete(3);



    }


}
