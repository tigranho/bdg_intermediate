package com.bdg.homework.airport.repository;

import com.bdg.homework.airport.configuration.DbConnection;
import com.bdg.homework.airport.model.Passenger;
import com.bdg.homework.airport.model.Trip;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public class TripDaoImpl implements TripDao {
    private Connection connection= DbConnection.getInstance().getConnection();
    private CompanyDao companyDao= new CompanyDaoImpl();
    private final static String GET_TRIP_BY_ID = "select * from trip where trip_number=?";
    private final static String GET_ALL_PASSENGERS = "select * from passenger";
    private final static String SAVE_PASSENGER = "insert  into passenger(name,phone,address_id) values (?,?,?)";
    private final static String UPDATE_PASSENGER = "update passenger set name=?,phone=?,address_id=?  where id=?";
    private final static String DELETE_PASSENGER = "delete from passenger where  id=?";




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
