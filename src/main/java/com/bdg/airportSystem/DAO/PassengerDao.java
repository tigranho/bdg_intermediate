package com.bdg.airportSystem.DAO;

import com.bdg.airportSystem.model.Passenger;
import com.bdg.airportSystem.model.Trip;

import java.util.List;
import java.util.Set;

public interface PassengerDao {

    Passenger getById(int id);
    Set<Passenger> getAll();
    Set<Passenger> get(int page, int perPage, String sort);
    Passenger save(Passenger passenger);
    Passenger update(Passenger passenger);
    void delete(int passengerId);
    List<Passenger> getPassengersOfTrip(long tripNumber);
    void registerTrip(Trip trip, Passenger passenger);
    void cancelTrip(long passengerId, long tripNumber);
    void writePassengersFromFileToDB();
}
