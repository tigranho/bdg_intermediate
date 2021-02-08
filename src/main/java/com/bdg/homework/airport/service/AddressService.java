package com.bdg.homework.airport.service;

import com.bdg.homework.airport.excpetions.AddressException;
import com.bdg.homework.airport.model.Address;

public interface AddressService {
    Address getById(int id) throws AddressException;
    Address save(final Address address) throws AddressException;
}
