package com.bdg.homework.airport.service.impl;

import com.bdg.homework.airport.enums.impl.AddressErrorCode;
import com.bdg.homework.airport.excpetions.AddressException;
import com.bdg.homework.airport.model.Address;
import com.bdg.homework.airport.repository.AddressDao;
import com.bdg.homework.airport.repository.PassengerDao;
import com.bdg.homework.airport.repository.impl.AddressDaoImpl;
import com.bdg.homework.airport.repository.impl.PassengerDaoImpl;
import com.bdg.homework.airport.service.AddressService;

public class AddressServiceImpl implements AddressService {

    private AddressDao addressDao;

    public AddressServiceImpl() {
        addressDao = new AddressDaoImpl();
    }



    @Override
    public Address getById(final int id) throws AddressException {
        if (id<=0){
            throw  new AddressException(AddressErrorCode.ADDRESS_NOT_VALID_ID);
        }
        Address address= addressDao.getById(id);
        if (address==null){
            throw  new AddressException(AddressErrorCode.ADDRESS_NOT_FOUND);
        }
        return null;
    }

    @Override
    public Address save(Address address) {
        return null;
    }

    @Override
    public void delete(int addressId) {

    }
}
