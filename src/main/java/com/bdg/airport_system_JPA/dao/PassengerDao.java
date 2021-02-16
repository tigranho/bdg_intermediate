package com.bdg.airport_system_JPA.dao;

import com.bdg.airport_system_JPA.model.Passenger;
import com.bdg.airport_system_JPA.model.Trip;

import java.util.List;
import java.util.Set;

public interface PassengerDao {

    Passenger getById(long id);
    Set<Passenger> getAll();
    Set<Passenger> get(int page, int perPage, String sort);
    Passenger save(Passenger passenger);
    Passenger update(Passenger passenger, long passengerId);
    void delete(long passengerId);
    void writePassengersFromFileToDB();
}
