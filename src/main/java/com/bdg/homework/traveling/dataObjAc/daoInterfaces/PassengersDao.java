package com.bdg.homework.traveling.dataObjAc.daoInterfaces;

import com.bdg.homework.traveling.model.Passenger;

import java.util.List;
import java.util.Set;

public interface PassengersDao {
    Passenger getById(int id);
    Set<Passenger> getAll();
    Set<Passenger> get(int page, int perPage, String sort);
    Passenger save(Passenger passenger);
    Passenger update(Passenger passenger, int id);
    void delete(long passengerId);
    List<Passenger> getPassengersOfTrip(long tripNumber);
    void registerTrip(TripDao trip, Passenger passenger);
    void cancelTrip(long passengerId, long tripNumber);

}