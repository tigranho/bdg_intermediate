package com.bdg;

import com.bdg.homework.hibernate_jpa.airport.configuration.HibernateUtil;
import com.bdg.homework.hibernate_jpa.airport.model.Passenger;


import javax.persistence.EntityManager;

/**
 * @author Aram
 */
public class Main {

    private String test;

    public static void main(String[] args) {

        EntityManager entityManager = HibernateUtil.entityManager();
        entityManager.getTransaction().begin();
        Passenger company;

         company = entityManager.find(Passenger.class, 3009);
        System.out.println(company);

    }


}
