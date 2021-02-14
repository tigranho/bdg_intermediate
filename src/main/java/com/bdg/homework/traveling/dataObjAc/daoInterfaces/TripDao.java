package com.bdg.homework.traveling.dataObjAc.daoInterfaces;

import com.bdg.homework.traveling.model.Trip;

import java.util.List;
import java.util.Set;

public interface TripDao {


    Trip getById(long id);
    Set<Trip> getAll();
    Set<Trip> get(int page, int perPage, String sort);
    Trip save(Trip passenger);
    Trip update(Trip passenger);
    void delete(long tripId);
    List<Trip> getTripsFrom(String city);
    List<Trip> getTripsTo(String city);

}
