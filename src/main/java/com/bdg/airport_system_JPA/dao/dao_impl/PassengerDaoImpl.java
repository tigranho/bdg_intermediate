package com.bdg.airport_system_JPA.dao.dao_impl;

import com.bdg.airport_system.model.Passenger;
import com.bdg.airport_system.model.Trip;
import com.bdg.airport_system_JPA.dao.PassengerDao;
import com.bdg.airport_system_JPA.model.Address;
import com.bdg.airport_system_JPA.util.ReadFile;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.bdg.airport_system_JPA.util.ReadFile.fromFileToList;

public class PassengerDaoImpl implements PassengerDao {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Hibernate_JPA");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    static Passenger passenger;
    Set<Passenger> passengers = new HashSet<>();

    @Override
    public Passenger getById(long id) {

        entityManager.getTransaction().begin();
        try {
            passenger = entityManager.find(Passenger.class, id);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
        return passenger;
    }

    @Override
    public Set<Passenger> getAll() {
        entityManager.getTransaction().begin();
        try {
            Query query = entityManager.createQuery("Select e from Company e");
            passengers = (Set<Passenger>) query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
        return passengers;
    }

    @Override
    public Set<Passenger> get(int page, int perPage, String sort) {
        return null;
    }

    @Override
    public Passenger save(Passenger passenger) {
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(passenger);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
        return passenger;
    }

    @Override
    public Passenger update(Passenger passenger, long passengerId) {
        entityManager.getTransaction().begin();
        try {
            PassengerDaoImpl.passenger = entityManager.find(Passenger.class, passengerId);
            PassengerDaoImpl.passenger.setAddress(passenger.getAddress());
            PassengerDaoImpl.passenger.setName(passenger.getName());
            PassengerDaoImpl.passenger.setPhone(passenger.getPhone());

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
        return PassengerDaoImpl.passenger;
    }

    @Override
    public void delete(long passengerId) {
        entityManager.getTransaction().begin();
        try {
            passenger = entityManager.find(Passenger.class, passengerId);
            entityManager.remove(passenger);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    @Override
    public List<Passenger> getPassengersOfTrip(long tripNumber) {
        return null;
    }

    @Override
    public void registerTrip(Trip trip, Passenger passenger) {

    }

    @Override
    public void cancelTrip(long passengerId, long tripNumber) {

    }

    @Override
    public void writePassengersFromFileToDB() {
        passenger = new Passenger();
        List<String> passengersList = fromFileToList(ReadFile.PASSENGERS_PATH);

        entityManager.getTransaction().begin();

        try {
            for (int i = 1; i < passengersList.size(); i++) {
                String[] passengersArray = passengersList.get(i).split(",");
                passenger.setName(passengersArray[0]);
                passenger.setPhone(passengersArray[1]);

                Address address = new Address();
                address.setCity(passengersArray[3]);
                address.setCountry(passengersArray[2]);

                entityManager.persist(passenger);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }

    }
}
