package com.bdg.airportSystem.DAO;

import com.bdg.airportSystem.model.Trip;

import java.util.List;
import java.util.Set;

public interface TripDao {

    Trip getById(int id);
    Set<Trip> getAll();
    Set<Trip> get(int page, int perPage, String sort);
    Trip save(Trip passenger);
    Trip update(Trip passenger);
    void delete(int tripId);
    List<Trip> getTripsFrom(String city);
    List<Trip> getTripsTo(String city);
}
