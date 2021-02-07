package com.bdg.airport.dao;

import com.bdg.airport.model.Address;

import java.util.Set;

public interface DaoAddress {
    Address getAddress(int id);

    void save(Address address);

    void saveAddressFromFile();

    void create();

    void delete(int id);

    void update(Address address);
}
