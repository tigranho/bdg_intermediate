package com.bdg;

import com.bdg.homework.airport.configuration.DbConnection;
import com.bdg.homework.airport.repository.PassengerDto;
import com.bdg.homework.airport.repository.PassengerDtoImpl;

import java.sql.Connection;

/**
 * @author Aram
 */
public class Main {

    public static void main(String[] args) {
        PassengerDto passengerDto= new PassengerDtoImpl();
        System.out.println(passengerDto.getAll());

    }


}
