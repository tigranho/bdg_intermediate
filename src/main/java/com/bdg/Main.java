package com.bdg;

import com.bdg.homework.airport.excpetions.impl.PassengerException;
import com.bdg.homework.airport.model.Passenger;
import com.bdg.homework.airport.repository.PassengerDao;
import com.bdg.homework.airport.repository.impl.PassengerDaoImpl;
import com.bdg.homework.airport.service.PassengerService;
import com.bdg.homework.airport.service.impl.PassengerServiceImpl;

import java.util.Set;

/**
 * @author Aram
 */
public class Main {

    public static void main(String[] args) {
        PassengerService service= new PassengerServiceImpl();
        try {
            service.delete(1);
        } catch (PassengerException e) {
         System.err.println(e);
        }


    }


}
