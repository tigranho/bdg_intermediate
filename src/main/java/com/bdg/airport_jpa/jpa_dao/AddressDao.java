package com.bdg.airport_jpa.jpa_dao;

import com.bdg.airport_jpa.model.Address;

import java.util.List;

public interface AddressDao {
    public void persist(Address entityAddress);

    public void update(Address entityAddress,int id);

    public Address findById(int id);

    public void delete(int id);

    public List<Address> findAll();

}
