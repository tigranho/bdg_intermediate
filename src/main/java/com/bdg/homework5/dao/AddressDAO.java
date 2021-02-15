package com.bdg.homework5.dao;

import com.bdg.homework5.entity.Address;

import java.util.List;

public interface AddressDAO {
    Address getById(int id);
    List<Address> getAll();
    Address save(Address address);
    void delete(int id);


}
