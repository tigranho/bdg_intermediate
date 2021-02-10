package com.bdg.homework.jdbc.airport.repository;

import com.bdg.homework.jdbc.airport.model.Address;

public interface AddressDao {

    Address getById(int id);
    Address save(final Address address);
    void delete(final  int addressId);

}
