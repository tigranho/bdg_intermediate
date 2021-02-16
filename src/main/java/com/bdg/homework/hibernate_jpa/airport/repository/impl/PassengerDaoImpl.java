package com.bdg.homework.hibernate_jpa.airport.repository.impl;

import com.bdg.homework.hibernate_jpa.airport.configuration.DbConnection;
import com.bdg.homework.hibernate_jpa.airport.model.Passenger;
import com.bdg.homework.hibernate_jpa.airport.model.Trip;
import com.bdg.homework.hibernate_jpa.airport.repository.AddressDao;
import com.bdg.homework.hibernate_jpa.airport.repository.PassengerDao;

import java.sql.*;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class PassengerDaoImpl implements PassengerDao {


    @Override
    public Passenger getById(int id) {
        return  null;

    }

    @Override
    public Set<Passenger> getAll() {
        return  null;

    }

    @Override
    public Set<Passenger> get(int page, int perPage, String sort) {
        return  null;

    }

    @Override
    public Passenger save(Passenger passenger) {
        return  null;

    }

    @Override
    public Passenger update(Passenger passenger) {
        return  null;

    }

    @Override
    public void delete(int passengerId) {

    }

    @Override
    public List<Passenger> getPassengersOfTrip(long tripNumber) {
        return null;
    }

    @Override
    public void registerTrip(Trip trip, Passenger passenger) {

    }

    @Override
    public void cancelTrip(long passengerId, long tripNumber) {

    }
}
