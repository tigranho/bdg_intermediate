package com.bdg.ams.repo.dao;

import com.bdg.ams.exception.DatabaseException;
import com.bdg.ams.model.Passenger;
import com.bdg.ams.model.Trip;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface PassengerDao {

    Optional<Passenger> getById(long id) throws DatabaseException;


    Set<Passenger> getAll();

    Set<Passenger> get(int page, int perPage, String sort);

    Passenger save(Passenger passenger);


    Passenger update(Passenger passenger);

    void delete(long passengerId);

    List<Passenger> getPassengersOfTrip(long tripNumber);

    void registerTrip(Trip trip, Passenger passenger);

    void cancelTrip(long passengerId, long tripNumber);
}
