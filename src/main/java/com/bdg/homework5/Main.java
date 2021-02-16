package com.bdg.homework5;

import com.bdg.homework5.dao.AddressDAO;
import com.bdg.homework5.dao.CompanyDAO;
import com.bdg.homework5.dao.PassengerDAO;
import com.bdg.homework5.dao.TripDAO;
import com.bdg.homework5.dao.impl.AddressDAOImpl;
import com.bdg.homework5.dao.impl.CompanyDAOImpl;
import com.bdg.homework5.dao.impl.PassengerDAOImpl;
import com.bdg.homework5.dao.impl.TripDAOImpl;
import com.bdg.homework5.entity.Address;
import com.bdg.homework5.entity.Company;
import com.bdg.homework5.entity.Passenger;
import com.bdg.homework5.entity.Trip;


import javax.persistence.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Main {
    public static void main(String[] args) {
        CompanyDAO companyDAO = new CompanyDAOImpl();
        Company company = new Company("Avialine15", Date.valueOf("2017-11-15"));
        company.setId(4);

    }
}

/*
*  EntityManagerFactory emf = null;
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        try {
            emf = Persistence.createEntityManagerFactory("Hibernate_JPA");
            entityManager = emf.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            Passenger passenger = new Passenger("Ara","Chill");
            Passenger passenger1 = new Passenger("Ara1","Chill1");
            //passenger.setAddress(new Address("Armenia","Yerevan"));
            entityManager.persist(passenger);
            entityManager.persist(passenger1);
            Address address = new Address("Armenia","Yerevan");
            address.addPassenger(passenger);
            address.addPassenger(passenger1);
            entityManager.persist(address);

            transaction.commit();
        }
        catch(Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally{
            entityManager.close();
            emf.close();
        }
        *
        * transaction.begin();
            Trip trip = new Trip();
            trip.setTime_in(Timestamp.valueOf("2017-11-15 15:30:14"));
            trip.setTime_out(Timestamp.valueOf("2017-11-15 20:30:14"));
            trip.setTown_from("London");
            trip.setTown_to("Liverpool");
            trip.setCompany(new Company("AviaLine", Date.valueOf("2017-11-15")));
            Company company = new Company("Avialine", Date.valueOf("2017-11-15"));
            company.addTrip(trip);
            entityManager.persist(company);
    }
    *
    *  Trip trip = new Trip();
        trip.setId(7);
        trip.setTime_in(Timestamp.valueOf("2017-11-15 15:30:14"));
        trip.setTime_out(Timestamp.valueOf("2017-11-15 20:30:14"));
        trip.setTown_from("Tehran2");
        trip.setTown_to("Moscow2");
        Company company = new Company();
        company.setId(3);
        trip.setCompany(company);
        Trip trip1 = tripDAO.update(trip);
        System.out.println(trip1.toString());
    */