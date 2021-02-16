package com.bdg.homework.hibernate_jpa.airport.service;

import com.bdg.homework.hibernate_jpa.airport.excpetions.impl.AddressException;
import com.bdg.homework.hibernate_jpa.airport.model.Address;

public interface AddressService {
    Address getById(int id) throws AddressException;
    Address save(final Address address) throws AddressException;
}
