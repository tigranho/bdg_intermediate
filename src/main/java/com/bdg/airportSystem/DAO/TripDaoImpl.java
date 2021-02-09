package com.bdg.airportSystem.DAO;

import com.bdg.airportSystem.config.ConnectionFactory;
import com.bdg.airportSystem.model.Trip;

import java.sql.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TripDaoImpl implements TripDao{

    private final Connection connection = ConnectionFactory.getConnection();
    private final CompanyDao companyDao= new CompanyDaoImpl();
    private final static String GET_TRIP_BY_ID = "select * from trip where trip_number=?";
    private final static String GET_ALL_TRIPS = "select * from trip";
    private final static String SAVE_TRIP = "insert  into trip(company_id,time_in,time_out,town_to,town_from) values (?,?,?,?,?)";





    @Override
    public Trip getById(int id) {
        Trip trip = null;
        try {
            PreparedStatement statement = connection.prepareStatement(GET_TRIP_BY_ID);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                 trip = getTrip(rs);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trip;
    }

    @Override
    public Set<Trip> getAll() {
        Trip trip;
        Set<Trip> trips = new HashSet<>();
        try {
            PreparedStatement statement = connection.prepareStatement(GET_ALL_TRIPS);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                trip = getTrip(rs);
                trips.add(trip);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trips;
    }

    private Trip getTrip(ResultSet rs) throws SQLException {
        Trip trip;
        trip = new Trip();
        trip.setTripNumber(rs.getInt(1));
        trip.setCompany(companyDao.getById(rs.getInt(2)));
        trip.setTimeIn(rs.getTimestamp(3).toLocalDateTime());
        trip.setTimeOut(rs.getTimestamp(4).toLocalDateTime());
        trip.setTownTo(rs.getString(5));
        trip.setTownFrom(rs.getString(6));
        return trip;
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
            try (ResultSet generateId = statement.getGeneratedKeys()) {
                if (generateId.next()) {
                    passenger.setTripNumber(generateId.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
