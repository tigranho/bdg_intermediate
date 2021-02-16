package com.bdg.homework.traveling.dataObjAc.daoInterfaces;

import com.bdg.homework.traveling.model.Trip;

import java.util.List;
import java.util.Set;

public interface TripDao {


    Trip getById(int id);
    Set<Trip> getAll();
    Set<Trip> get(int page, int perPage, String sort);
    Trip save(Trip passenger);
    Trip update(Trip passenger, int id);
    void delete(int tripId);
    List<Trip> getTripsFrom(String city);
    List<Trip> getTripsTo(String city);

}