package com.bdg.airport.dao;

import com.bdg.airport.model.Passenger;
import com.bdg.airport.model.Trip;

import java.util.List;
import java.util.Set;

public interface DaoPassenger {
    Set<Passenger> getAll();

    Set<Passenger> get(int page, int perPage, String sort);

    void create();

    void savePassengersFromFile();

    void save(Passenger passenger);

    void update(Passenger passenger);

    void delete(int passengerId);

    List<Passenger> getPassengersOfTrip(long tripNumber);

    void registerTrip(Trip trip, Passenger passenger);

    void cancelTrip(long passengerId, long tripNumber);
}
