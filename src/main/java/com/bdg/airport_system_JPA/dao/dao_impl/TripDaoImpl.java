package com.bdg.airport_system_JPA.dao.dao_impl;

import com.bdg.airport_system_JPA.model.Trip;
import com.bdg.airport_system_JPA.dao.TripDao;

import java.util.List;
import java.util.Set;

public class TripDaoImpl implements TripDao {
    @Override
    public Trip getById(long id) {
        return null;
    }

    @Override
    public Set<Trip> getAll() {
        return null;
    }

    @Override
    public Set<Trip> get(int page, int perPage, String sort) {
        return null;
    }

    @Override
    public Trip save(Trip passenger) {
        return null;
    }

    @Override
    public Trip update(Trip passenger) {
        return null;
    }

    @Override
    public void delete(long tripId) {

    }

    @Override
    public List<Trip> getTripsFrom(String city) {
        return null;
    }

    @Override
    public List<Trip> getTripsTo(String city) {
        return null;
    }
}
