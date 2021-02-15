package com.bdg.homework5.dao.impl;

import com.bdg.homework5.dao.AddressDAO;
import com.bdg.homework5.entity.Address;
import com.bdg.homework5.entity.Passenger;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

public class AddressDAOImpl implements AddressDAO {
    EntityManagerFactory emf = null;
    EntityManager entityManager = null;
    EntityTransaction transaction = null;

    @Override
    public Address getById(int id) {
          Address address = null;
        try {
            emf = Persistence.createEntityManagerFactory("Hibernate_JPA");
            entityManager = emf.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            TypedQuery<Address> query = entityManager.createQuery("SELECT a from Address a left JOIN FETCH a.passengerSet where a.Id = ?1",Address.class);
            address = query.setParameter(1,id).getSingleResult();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
            emf.close();
        }
        return address;
    }


    @Override
    public List<Address> getAll() {
        List<Address> addressList = null;
        try {
            emf = Persistence.createEntityManagerFactory("Hibernate_JPA");
            entityManager = emf.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            TypedQuery<Address> query = entityManager.createQuery("SELECT a from Address a left JOIN FETCH a.passengerSet",Address.class);
            addressList = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
            emf.close();
        }
        return addressList;
    }

    @Override
    public Address save(Address address) {
        EntityManagerFactory emf = null;
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        Address address1 = null;
        try {
            emf = Persistence.createEntityManagerFactory("Hibernate_JPA");
            entityManager = emf.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(address);
            entityManager.flush();
            address1 = address;
            transaction.commit();
        }
        catch(Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally{
            entityManager.close();
            emf.close();
        }
        return address1;
    }

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
            entityManager.createQuery("delete  from Address  where  Id = ?1").setParameter(1,id).executeUpdate();
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

