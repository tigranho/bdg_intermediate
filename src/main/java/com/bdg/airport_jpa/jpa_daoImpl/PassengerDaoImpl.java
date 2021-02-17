package com.bdg.airport_jpa.jpa_daoImpl;

import com.bdg.airport_jpa.jpa_dao.PassengerDao;
import com.bdg.airport_jpa.model.Passenger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class PassengerDaoImpl implements PassengerDao {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Hibernate_JPA");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    @Override
    public void persist(Passenger entityPassenger) {
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(entityPassenger);
            entityManager.getTransaction().commit();
        }catch (Exception exception){
            entityManager.getTransaction().rollback();
        }
        finally {
            entityManager.close();
        }
    }

    @Override
    public void update(Passenger entityPassenger, int id) {

    }

    @Override
    public Passenger findById(int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Passenger> findAll() {
        return null;
    }
    public static EntityManagerFactory getEntityManagerFactory() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Hibernate_JPA");
        return entityManagerFactory;
    }
}
