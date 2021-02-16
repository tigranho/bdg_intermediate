package com.bdg.homework5.dao.impl;

import com.bdg.homework5.dao.PassengerDAO;
import com.bdg.homework5.entity.Address;
import com.bdg.homework5.entity.Passenger;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * this class is responsible for doing some crud operations with Passenger entity
 *
 */
public class PassengerDAOImpl implements PassengerDAO {

    /**
     * @param id by the given id we can found the Passenger
     * @return Passenger that we found in our DB
     */
    @Override
    public Passenger getById(int id) {
        EntityManagerFactory emf = null;
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        Passenger passenger = null;
        try {
            emf = Persistence.createEntityManagerFactory("Hibernate_JPA");
            entityManager = emf.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            TypedQuery<Passenger> query = entityManager.createQuery("SELECT p from Passenger p left JOIN FETCH p.address where p.Id = ?1",Passenger.class);
            passenger = query.setParameter(1,id).getSingleResult();
            System.out.println(passenger.toString());
            transaction.commit();
        }
        catch(Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally{
            entityManager.close();
            emf.close();
        }
        return passenger;
    }

    /**
     *
     * @return all passengers in db
     */

    @Override
    public List<Passenger> getAll() {
        EntityManagerFactory emf = null;
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        List<Passenger> passengerSet = null;
        try {
            emf = Persistence.createEntityManagerFactory("Hibernate_JPA");
            entityManager = emf.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            TypedQuery<Passenger> query = entityManager.createQuery("SELECT p from Passenger p left JOIN FETCH p.address",Passenger.class);
            passengerSet = query.getResultList();
            transaction.commit();
        }
        catch(Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally{
            entityManager.close();
            emf.close();
        }
        return passengerSet;
    }

    /**
     *
     * @param addressId given param to find all passengers living in that address
     * @return return list of passengers that have the same address_id
     */
    @Override
    public List<Passenger> getByAddressId(int addressId) {
        EntityManagerFactory emf = null;
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        List<Passenger> passengerSet = null;
        try {
            emf = Persistence.createEntityManagerFactory("Hibernate_JPA");
            entityManager = emf.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            passengerSet = entityManager.createQuery("SELECT p from Passenger p left JOIN FETCH p.address where p.address.Id = ?1",Passenger.class)
                    .setParameter(1,addressId).getResultList();
           // passengerSet = query.getResultList();
            transaction.commit();
        }
        catch(Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally{
            entityManager.close();
            emf.close();
        }
        return passengerSet;
    }

    /**
     *
     * @param passenger this passenger include inside also address
     * @return saved passenger
     */

    @Override
    public Passenger save(Passenger passenger) {
        EntityManagerFactory emf = null;
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        Passenger passenger1 = null;
        try {
            emf = Persistence.createEntityManagerFactory("Hibernate_JPA");
            entityManager = emf.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(passenger.getAddress());
            entityManager.persist(passenger);
            entityManager.flush();
            passenger1 = passenger;
            transaction.commit();
        }
        catch(Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally{
            entityManager.close();
            emf.close();
        }
        return passenger1;
    }

    /**
     *
     * @param passenger in this method the param passenger does not include address
     * @param addressId to find address reference in db
     * @return saved passenger
     */
    @Override
    public Passenger save(Passenger passenger, int addressId) {
        EntityManagerFactory emf = null;
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        Passenger passenger1 = null;
        try {
            emf = Persistence.createEntityManagerFactory("Hibernate_JPA");
            entityManager = emf.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            Address address = entityManager.getReference(Address.class,addressId);
            passenger.setAddress(address);
            entityManager.persist(passenger);
            entityManager.flush();
            passenger1 = entityManager.createQuery("SELECT p from Passenger p left JOIN FETCH p.address where p.address.Id = ?1 and p.Id = ?2",Passenger.class)
                    .setParameter(1,addressId).setParameter(2,passenger.getId()).getSingleResult();
            transaction.commit();
        }
        catch(Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally{
            entityManager.close();
            emf.close();
        }
        return passenger1;
    }

    /**
     *
     * @param passId to find the exact passenger for updateing
     * @param passenger this is new Passenger
     * @return updated passenger
     */
    @Override
    public Passenger update(int passId, Passenger passenger) {
        EntityManagerFactory emf = null;
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        Passenger passenger1 = null;
        try {
            emf = Persistence.createEntityManagerFactory("Hibernate_JPA");
            entityManager = emf.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            passenger.setId(passId);
            Address address = passenger.getAddress();
            entityManager.persist(address);
            entityManager.merge(passenger);
            entityManager.flush();
            passenger1 = entityManager.createQuery("SELECT p from Passenger p left JOIN FETCH p.address where  p.Id = ?1",Passenger.class)
                    .setParameter(1,passenger.getId()).getSingleResult();
            transaction.commit();
        }
        catch(Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally{
            entityManager.close();
            emf.close();
        }
        return passenger1;
    }

    /**
     *
     * @param id responsible for deleting the Passenger by given id
     */
    @Override
    public void delete(int id) {
        EntityManagerFactory emf = null;
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        try {
            emf = Persistence.createEntityManagerFactory("Hibernate_JPA");
            entityManager = emf.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.createQuery("delete  from Passenger  where  Id = ?1").setParameter(1,id).executeUpdate();
            transaction.commit();
        }
        catch(Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally{
            entityManager.close();
            emf.close();
        }
    }
}
