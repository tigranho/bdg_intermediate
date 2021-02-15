package com.bdg.homework5.dao;

import com.bdg.homework5.entity.Passenger;

import java.util.List;

public interface PassengerDAO {
    Passenger getById(int id);
    List<Passenger> getAll();
    List<Passenger> getByAddressId(int addressId);
    Passenger save(Passenger passenger);
    Passenger save(Passenger passenger,int addressId);
    Passenger update(int passId,Passenger passenger);
    void delete(int id);
}
