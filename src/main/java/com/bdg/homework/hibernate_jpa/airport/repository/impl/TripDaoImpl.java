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
    private Connection connection= DbConnection.getInstance().getConnection();
    private CompanyDao companyDao= new CompanyDaoImpl();
    private final static String GET_TRIP_BY_ID = "select * from trip where trip_number=?";
    private final static String GET_ALL_TRIPS = "select * from trip";
    private final static String SAVE_TRIP = "insert  into trip(company_id,time_in,time_out,town_to,town_from) values (?,?,?,?,?)";





    @Override
    public Trip getById(int id) {
        Trip trip = null;
        try {
            PreparedStatement statement = connection.prepareStatement(GET_TRIP_BY_ID);
            statement.setInt(1, id);
            ResultSet res = statement.executeQuery();
            if (res.next()) {
                trip = new Trip();
                trip.setTripNumber(res.getInt(1));
                trip.setCompany(companyDao.getById(res.getInt(2)));
                trip.setTimeIn(res.getTimestamp(3).toLocalDateTime());
                trip.setTimeOut(res.getTimestamp(4).toLocalDateTime());
                trip.setTownTo(res.getString(5));
                trip.setTownFrom(res.getString(6));

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return trip;
    }

    @Override
    public Set<Trip> getAll() {
        Trip trip = null;
        Set<Trip> trips = new TreeSet<>();
        try {
            PreparedStatement statement = connection.prepareStatement(GET_ALL_TRIPS);
            ResultSet res = statement.executeQuery();
            while (res.next()) {
                trip = new Trip();
                trip.setTripNumber(res.getInt(1));
                trip.setCompany(companyDao.getById(res.getInt(2)));
                trip.setTimeIn(res.getTimestamp(3).toLocalDateTime());
                trip.setTimeOut(res.getTimestamp(4).toLocalDateTime());
                trip.setTownTo(res.getString(5));
                trip.setTownFrom(res.getString(6));
                trips.add(trip);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return trips;
    }

    @Override
    public Set<Trip> get(int page, int perPage, String sort) {
        return null;
    }

    @Override
    public Trip save(Trip passenger) {
        try {
            PreparedStatement statement = connection.prepareStatement(SAVE_TRIP, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1,passenger.getCompany().getId());
            statement.setTimestamp(2, Timestamp.valueOf(passenger.getTimeIn()));
            statement.setTimestamp(3, Timestamp.valueOf(passenger.getTimeOut()));
            statement.setString(4,passenger.getTownTo());
            statement.setString(5,passenger.getTownFrom());
            statement.executeUpdate();
            try (ResultSet genId = statement.getGeneratedKeys()) {
                if (genId.next()) {
                    passenger.setTripNumber(genId.getInt(1));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return passenger;
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
