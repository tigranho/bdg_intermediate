package com.bdg.airport_system_JPA.dao;

import com.bdg.airport_system_JPA.model.Address;

import java.util.List;

public interface AddressDao {

    Address getById(long id);
    Address save (Address address);
    void update (Address address, long id);
    void delete (long id);
    List<Address> getAll();
    void writeAddressFromFileIntoDB();

}
