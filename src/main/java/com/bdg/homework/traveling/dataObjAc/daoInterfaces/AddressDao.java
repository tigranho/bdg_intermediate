package com.bdg.homework.traveling.dataObjAc.daoInterfaces;

public interface AddressDao {

    AddressDao getById(int addresID);
    AddressDao getAll();
    AddressDao saveAddress(AddressDao address);




}
