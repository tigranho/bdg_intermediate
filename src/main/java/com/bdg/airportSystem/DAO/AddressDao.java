package com.bdg.airportSystem.DAO;

import com.bdg.airportSystem.model.Address;

public interface AddressDao {

    Address getById(int id);
    Address save ( Address address);
    void writeAddressFromFileIntoDB();
}
