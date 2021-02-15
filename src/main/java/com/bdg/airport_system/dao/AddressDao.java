package com.bdg.airport_system.dao;

import com.bdg.airport_system.model.Address;

public interface AddressDao {

    Address getById(int id);
    Address save ( Address address);
    void writeAddressFromFileIntoDB();
}
