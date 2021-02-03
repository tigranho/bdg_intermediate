package com.bdg.homework.airport.repository;

import com.bdg.homework.airport.model.Address;
import com.bdg.homework.airport.model.Passenger;

public interface AddressDao {

    Address getById(int id);
    Address save(final Address address);
}
