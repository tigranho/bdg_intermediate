package com.bdg.ams.repo.dao;

import com.bdg.ams.exception.DatabaseException;
import com.bdg.ams.model.Address;

import java.util.Optional;

public interface AddressDao {

    Address save(Address address);
    Optional<Address> getById(long id) throws DatabaseException;
}
