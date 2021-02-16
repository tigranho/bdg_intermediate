package com.bdg.homework.hibernate_jpa.airport.service.impl;

import com.bdg.homework.hibernate_jpa.airport.enums.impl.AddressErrorCode;
import com.bdg.homework.hibernate_jpa.airport.excpetions.impl.AddressException;
import com.bdg.homework.hibernate_jpa.airport.model.Address;
import com.bdg.homework.hibernate_jpa.airport.repository.AddressDao;
import com.bdg.homework.hibernate_jpa.airport.repository.impl.AddressDaoImpl;
import com.bdg.homework.hibernate_jpa.airport.service.AddressService;
import com.bdg.homework.hibernate_jpa.airport.validator.AddressValidate;

public class AddressServiceImpl implements AddressService {

    private final AddressDao addressDao;

    public AddressServiceImpl() {
        addressDao = new AddressDaoImpl();
    }


    @Override
    public Address getById(final int id) throws AddressException {
        if (id <= 0) {
            throw new AddressException(AddressErrorCode.ADDRESS_NOT_VALID_ID);
        }
        Address address = addressDao.getById(id);
        if (address == null) {
            throw new AddressException(AddressErrorCode.ADDRESS_NOT_FOUND);
        }
        return address;
    }

    @Override
    public Address save(final Address address) throws AddressException {
        if (address == null || AddressValidate.checkFields(address)) {
            throw new AddressException(AddressErrorCode.ADDRESS_IS_EMPTY);
        }
        return addressDao.save(address);
    }
}
