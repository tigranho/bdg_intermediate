package com.bdg.homework.airport.service;

import com.bdg.homework.airport.excpetions.impl.PassengerException;
import com.bdg.homework.airport.model.Passenger;
import com.bdg.homework.airport.model.Trip;

import java.util.List;
import java.util.Set;

public interface PassengerService {

    Passenger save(final Passenger passenger) throws PassengerException;

    Passenger getById( final int id) throws PassengerException;

    Set<Passenger> getAll();

    Set<Passenger> get(int page, int perPage, String sort);

    Passenger update(Passenger passenger) throws PassengerException;

    void delete(final int passengerId) throws PassengerException;

    List<Passenger> getPassengersOfTrip(long tripNumber);

    void registerTrip(Trip trip, Passenger passenger);

    void cancelTrip(long passengerId, long tripNumber);


}


