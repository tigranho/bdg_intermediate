package com.bdg;

import com.bdg.homework.hibernate_jpa.airport.configuration.HibernateUtil;
import com.bdg.homework.jdbc.airport.controller.PassengerController;
import com.bdg.homework.jdbc.airport.excpetions.impl.PassengerException;
import com.bdg.homework.jdbc.airport.model.Address;
import com.bdg.homework.jdbc.airport.model.Passenger;

/**
 * @author Aram
 */
public class Main {

    private String test;

    public static void main(String[] args) {

        HibernateUtil.entityManager().getTransaction().begin();

    }


}
