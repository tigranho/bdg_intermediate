package com.bdg.homework.hibernate_jpa.airport.repository.impl;

import com.bdg.homework.hibernate_jpa.airport.configuration.HibernateUtil;
import com.bdg.homework.hibernate_jpa.airport.model.Address;
import com.bdg.homework.hibernate_jpa.airport.repository.AddressDao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class AddressDaoImpl implements AddressDao {

    private EntityManager manager = HibernateUtil.entityManager();

    @Override
    public Address getById(final int id) {
        Address address = null;
        try {
            manager.getTransaction().begin();
            address = manager.find(Address.class, id);
            manager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (!(manager == null) && manager.isOpen()) {
                manager.close();
            }
        }
        return address;
    }

    @Override
    public Address save(final Address address) {
        try {
            manager.getTransaction().begin();
            manager.persist(address);
            manager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (!(manager == null) && manager.isOpen()) {
                manager.close();
            }
        }

        return address;
    }

    @Override
    public void delete(final int addressId) {
        try {
            manager.getTransaction().begin();
            Query query= manager.createQuery("delete from Address where  id=:addressId");
            query.setParameter("addressId",addressId);
            query.executeUpdate();
            manager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (!(manager == null) && manager.isOpen()) {
                manager.close();
            }
        }
    }
}
