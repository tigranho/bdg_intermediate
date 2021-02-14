package com.bdg.homework.traveling.dataObjAc.daoInterfaces;

import com.bdg.homework.traveling.model.Address;

public interface AddressDao {

    Address getById(int addresID);
    Address getAll();
    Address saveAddress(Address address);




}
