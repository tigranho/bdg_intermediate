package com.bdg.homework.hibernate_jpa.airport.repository.impl;

import com.bdg.homework.hibernate_jpa.airport.configuration.DbConnection;
import com.bdg.homework.hibernate_jpa.airport.model.Trip;
import com.bdg.homework.hibernate_jpa.airport.repository.CompanyDao;
import com.bdg.homework.hibernate_jpa.airport.repository.TripDao;

import java.sql.*;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TripDaoImpl implements TripDao {




    @Override
    public Trip getById(int id) {
        return  null;

    }

    @Override
    public Set<Trip> getAll() {
        return  null;


    }

    @Override
    public Set<Trip> get(int page, int perPage, String sort) {
        return null;
    }

    @Override
    public Trip save(Trip passenger) {
        return  null;

    }

    @Override
    public Trip update(Trip passenger) {
        return null;
    }

    @Override
    public void delete(int tripId) {

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
