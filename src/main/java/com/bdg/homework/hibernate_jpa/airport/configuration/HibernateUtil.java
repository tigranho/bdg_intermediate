package com.bdg.homework.hibernate_jpa.airport.configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    private HibernateUtil() {

    }

    private static EntityManagerFactory entityManagerFactory() {
        entityManagerFactory = Persistence.createEntityManagerFactory("Hibernate_JPA");

        return entityManagerFactory;
    }

    public static EntityManager entityManager() {
        entityManager = entityManagerFactory().createEntityManager();
        return entityManager;
    }

}
