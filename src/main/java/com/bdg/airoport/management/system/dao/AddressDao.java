package com.bdg.airoport.management.system.dao;

import com.bdg.airoport.management.system.model.Address;

public interface AddressDao {
    Address getById(int id);
    Address save(Address address);
    void delete(int addressId);
}
