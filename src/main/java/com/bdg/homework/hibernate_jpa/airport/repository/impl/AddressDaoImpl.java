package com.bdg.homework.hibernate_jpa.airport.repository.impl;

import com.bdg.homework.hibernate_jpa.airport.configuration.HibernateUtil;
import com.bdg.homework.hibernate_jpa.airport.model.Address;
import com.bdg.homework.hibernate_jpa.airport.repository.AddressDao;

import javax.persistence.EntityManager;

public class AddressDaoImpl implements AddressDao {

    private EntityManager manager = HibernateUtil.entityManager();

    @Override
    public Address getById(final int id) {
        Address address = manager.find(Address.class, id);
        return address;
    }

    @Override
    public Address save(final Address address) {
        manager.getTransaction().begin();
        manager.persist(address);
        manager.getTransaction().commit();
        return address;
    }

    @Override
    public void delete(int addressId) {


    }
}
