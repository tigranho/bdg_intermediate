package com.bdg;

import com.bdg.homework.jdbc.airport.controller.PassengerController;
import com.bdg.homework.jdbc.airport.excpetions.impl.PassengerException;
import com.bdg.homework.jdbc.airport.model.Address;
import com.bdg.homework.jdbc.airport.model.Passenger;

/**
 * @author Aram
 */
public class Main {

    public static void main(String[] args) {
        PassengerController controller= new PassengerController();
        Address address= new Address("Yerevan","Armenia");
        Passenger passenger= new Passenger("Poxosopoxosyan","",address);
        try {
            controller.save(passenger);
        } catch (PassengerException e) {
            e.printStackTrace();
        }


    }


}
