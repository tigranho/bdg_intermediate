package com.bdg.homework.hibernate_jpa.airport.repository;

import com.bdg.homework.hibernate_jpa.airport.model.Address;

public interface AddressDao {

    Address getById(int id);
    Address save(final Address address);
    void delete(final  int addressId);

}
