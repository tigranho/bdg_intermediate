package com.bdg.airport.dao;

import com.bdg.airport.model.Trip;

import java.util.List;
import java.util.Set;

public interface DaoTrip {
    void create();
    Set<Trip> getAll();

    Set<Trip> get(int page, int perPage, String sort);

    void save(Trip trip);

    void update(Trip trip);

    void delete(int tripId);

    List<Trip> getTripsFrom(String city);

    List<Trip> getTripsTo(String city);
}
