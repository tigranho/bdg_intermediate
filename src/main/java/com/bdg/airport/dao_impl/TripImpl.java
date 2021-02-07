package com.bdg.airport.dao_impl;

import com.bdg.airport.dao.DaoTrip;
import com.bdg.airport.jdbc.JDBC;
import com.bdg.airport.model.Trip;

import java.sql.*;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TripImpl implements DaoTrip {
    private final static String DELETE_QUERY = "DELETE FROM airport.trip WHERE  id=?";
    private final static String UPDATE_QUERY = "UPDATE airport.trip SET company_id = ?,time_in = ?,time_out=?,town_too=?,town_from=? WHERE id = ?";
    private final static String SAVE_QUERY = "INSERT INTO airport.trip (company_id, time_in,time_out,town_too,town_from)" + " values (?, ?, ?, ?, ?)";
    private final static String CREATE_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS airport.trip (" + "id INT AUTO_INCREMENT NOT NULL," + "company_id INT NOT NULL," + "time_in TIME NOT NULL," + "time_out TIME NOT NULL," + "town_too VARCHAR(255) NOT NULL," + "town_from VARCHAR(255) NOT NULL," + "PRIMARY KEY (id))";
    private final static String GET_ALL_Trip = "SELECT * FROM airport.trip";
    Connection conn;
    PreparedStatement preparedStatement = null;

    {
        try {
            conn = DriverManager.getConnection(JDBC.JdbcInit.DB_URL, JDBC.JdbcInit.USER, JDBC.JdbcInit.PASS);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    @Override
    public void create() {
        try {
            System.out.println("Creating table trip in given database...");
            PreparedStatement preparedStatement = conn.prepareStatement(CREATE_TABLE_QUERY);
            preparedStatement.executeUpdate();
            System.out.println("Created table trip in given database...");
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }


    @Override
    public Set<Trip> getAll() {

        Trip trip = null;
        Set<Trip> trips = new TreeSet<>();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(GET_ALL_Trip);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                trip.setCompanyid(resultSet.getInt(1));
                trip.setTime_in(resultSet.getTime(2).toLocalTime());
                trip.setTime_out(resultSet.getTime(3).toLocalTime());
                trip.setTown_too(resultSet.getString(4));
                trip.setTown_from(resultSet.getString(5));
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
    public void save(Trip trip) {
        try {
            preparedStatement = conn.prepareStatement(SAVE_QUERY);
            preparedStatement.setInt(1,trip.getCompanyid());
            preparedStatement.setObject(2, trip.getTime_in());
            preparedStatement.setObject(3, trip.getTime_out());
            preparedStatement.setString(4, trip.getTown_too());
            preparedStatement.setString(5, trip.getTown_from());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Trip trip) {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_QUERY);
            preparedStatement.setInt(1,trip.getCompanyid());
            preparedStatement.setObject(2, trip.getTime_in());
            preparedStatement.setObject(3, trip.getTime_out());
            preparedStatement.setString(4, trip.getTown_too());
            preparedStatement.setString(5, trip.getTown_from());
            preparedStatement.setInt(6,trip.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

    }

    @Override
    public void delete(int tripId) {try {
        PreparedStatement preparedStatement = conn.prepareStatement(DELETE_QUERY);
        preparedStatement.setInt(1, tripId);
        preparedStatement.executeUpdate();
    } catch (SQLException exception) {
        exception.printStackTrace();
    }


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
