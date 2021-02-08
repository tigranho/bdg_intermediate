package com.bdg.airoport.management.system.services;

import com.bdg.airoport.management.system.model.Address;

public interface AddressService {
    Address getById(int id);
    Address save(Address address);
    void delete(int addressId);
}
