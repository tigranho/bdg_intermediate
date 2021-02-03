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
import java.util.TreeSet;

public class PassengerDtoImpl implements PassengerDto {
    private final static String GET_PASSENGER_BY_ID = "select * from passenger where id=?";
    private final static String GET_ALL_PASSENGERS = "select * from passenger";
    private final Connection connection = DbConnection.getInstance().getConnection();
    private final AddressDao addressDao = new AddressDaoImpl();

    @Override
    public Passenger getById(int id) {
        Passenger passenger = null;
        AddressDao addressDao = new AddressDaoImpl();
        try {
            PreparedStatement statement = connection.prepareStatement(GET_PASSENGER_BY_ID);
            statement.setInt(1, id);
            ResultSet res = statement.executeQuery();
            while (res.next()) {
                passenger = new Passenger();
                passenger.setId(res.getInt(1));
                passenger.setName(res.getString(2));
                passenger.setPhone(res.getString(3));
                passenger.setAddress(addressDao.getById(res.getInt(4)));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return passenger;
    }

    @Override
    public Set<Passenger> getAll() {
        Passenger passenger = null;
        Set<Passenger> passengers = new TreeSet<>();
        try {
            PreparedStatement statement = connection.prepareStatement(GET_ALL_PASSENGERS);
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                passenger = new Passenger();
                passenger.setId(set.getInt(1));
                passenger.setName(set.getString(2));
                passenger.setPhone(set.getString(3));
                passenger.setAddress(addressDao.getById(set.getInt(4)));
                passengers.add(passenger);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return passengers;
    }

    @Override
    public Set<Passenger> get(int page, int perPage, String sort) {
        return null;
    }

    @Override
    public Passenger save(Passenger passenger) {
        return null;
    }

    @Override
    public Passenger update(Passenger passenger) {
        return null;
    }

    @Override
    public void delete(long passengerId) {

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
