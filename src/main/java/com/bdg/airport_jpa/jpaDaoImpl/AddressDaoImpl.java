package com.bdg.airport_jpa.jpaDaoImpl;

import com.bdg.airport_jpa.jpaDao.AddressDao;
import com.bdg.airport_jpa.model.Address;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class AddressDaoImpl implements AddressDao {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Hibernate_JPA");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    @Override
    public void persist(Address entityAddress) {
     entityManager.getTransaction().begin();
        try {
            entityManager.persist(entityAddress);
            entityManager.getTransaction().commit();
        }catch (Exception exception){
            entityManager.getTransaction().rollback();
        }
        finally {
            entityManager.close();
        }
    }

    @Override
    public void update(Address entityAddress,int id) {
        entityManager.getTransaction().begin();
        try {
            Address address= entityManager.find(Address.class,id);
            address.setCity(entityAddress.getCity());
            address.setCountry(entityAddress.getCountry());
            entityManager.getTransaction().commit();
        }catch (Exception exception){
            entityManager.getTransaction().rollback();
        }
        finally {
            entityManager.close();
        }

    }

    @Override
    public Address findById(int id) {
        Address address = null;
        entityManager.getTransaction().begin();
        try {
            address = entityManager.find(Address.class, id);
            entityManager.getTransaction().commit();
        }catch (Exception exception){
            entityManager.getTransaction().rollback();
        }finally {
            entityManager.close();
        }
        return address;
    }

    @Override
    public void delete(int id) {
        entityManager.getTransaction().begin();
        try {
            Address address = entityManager.find(Address.class, id);
            entityManager.remove(address);
            entityManager.getTransaction().commit();
        }catch (Exception exception){
            entityManager.getTransaction().rollback();
        }finally {
            entityManager.close();
        }
    }

    @Override
    public List<Address> findAll() {
        entityManager.getTransaction().begin();
        List<Address> result = null;
        try {

            TypedQuery<Address> query = entityManager.createQuery("SELECT c FROM Address c", Address.class);
            result = query.getResultList();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }finally {
            entityManager.close();
        }
        return result;
    }
    public static EntityManagerFactory getEntityManagerFactory() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Hibernate_JPA");
        return entityManagerFactory;
    }
}
