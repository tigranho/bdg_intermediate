package com.bdg.homework.jdbc.airport.service;

import com.bdg.homework.jdbc.airport.excpetions.impl.AddressException;
import com.bdg.homework.jdbc.airport.model.Address;

public interface AddressService {
    Address getById(int id) throws AddressException;
    Address save(final Address address) throws AddressException;
}
