package com.bdg.airport_jpa.util;

import com.bdg.airport.util.ReadDataFromFile;
import com.bdg.airport_jpa.model.Address;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public  class ReadFromFile {

    public static final String PATH_PASSENGERS="src/main/resources/passengers.txt";
    public static final String PATH_COMPANIES="src/main/resources/companies.txt";
    public static List<String> readFile(String file) {

        List<String> lines = Collections.emptyList();

        try {
            lines = Files.readAllLines(Paths.get(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public void addAddressToDb(List<String> list) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Hibernate_JPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        list = new ArrayList<>();
        list = (readFile(ReadDataFromFile.PATH_PASSENGERS));
        for (int j = 1; j < list.size(); j++) {
            Address address = new Address();
            String[] strings = list.get(j).split(",");
            address.setCountry(strings[2]);
            address.setCity(strings[3]);
            entityManager.persist(address);
        }
        entityManager.flush();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

}

