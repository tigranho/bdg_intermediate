package com.bdg;

import com.bdg.homework.hibernate_jpa.airport.configuration.HibernateUtil;
import com.bdg.homework.hibernate_jpa.airport.model.Company;
import com.bdg.homework.jdbc.airport.controller.PassengerController;
import com.bdg.homework.jdbc.airport.excpetions.impl.PassengerException;
import com.bdg.homework.jdbc.airport.model.Address;
import com.bdg.homework.jdbc.airport.model.Passenger;

import javax.persistence.EntityManager;

/**
 * @author Aram
 */
public class Main {

    private String test;

    public static void main(String[] args) {

        EntityManager entityManager = HibernateUtil.entityManager();
        entityManager.getTransaction().begin();
        Company company;

         company = entityManager.find(Company.class, 7);
        System.out.println(company);

    }


}
