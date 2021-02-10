package com.bdg.homework.jdbc.airport.repository.impl;

import com.bdg.homework.jdbc.airport.configuration.DbConnection;
import com.bdg.homework.jdbc.airport.model.Passenger;
import com.bdg.homework.jdbc.airport.model.Trip;
import com.bdg.homework.jdbc.airport.repository.AddressDao;
import com.bdg.homework.jdbc.airport.repository.PassengerDao;

import java.sql.*;
import java.util.*;

public class PassengerDaoImpl implements PassengerDao {
    private final String GET_PASSENGER_BY_ID = "select * from passenger where id=?";
    private final String GET_ALL_PASSENGERS = "select * from passenger";
    private final String SAVE_PASSENGER = "insert  into passenger(name,phone,address_id) values (?,?,?)";
    private final String UPDATE_PASSENGER = "update passenger set name=?,phone=?,address_id=?  where id=?";
    private final String DELETE_PASSENGER = "delete from passenger where  id=?";
    private final Connection connection = DbConnection.getInstance().getConnection();
    private final AddressDao addressDao = new AddressDaoImpl();
    private String SELECT_PASSENGER_BY_LIMIT = "select * from passenger order by id ";

    @Override
    public Passenger getById(int id) {
        Passenger passenger = null;
        try {
            PreparedStatement statement = connection.prepareStatement(GET_PASSENGER_BY_ID);
            statement.setInt(1, id);
            ResultSet res = statement.executeQuery();
            if (res.next()) {
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
        Passenger passenger = null;
        Set<Passenger> passengers = new TreeSet<>();
        if (!sort.equals("desc") || !sort.equals("asc")) {
            new IllegalArgumentException();
        }
        if (page < 0 || perPage < 0) {
            new IllegalArgumentException();
        } else {
            page = page * 10;
        }
        try {
            SELECT_PASSENGER_BY_LIMIT = SELECT_PASSENGER_BY_LIMIT.concat(sort).concat(" ")
                    .concat("limit " + perPage).concat(" ").concat("OFFSET " + page);
            PreparedStatement statement = connection.prepareStatement(SELECT_PASSENGER_BY_LIMIT);
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
    public Passenger save(Passenger passenger) {
        try {
            PreparedStatement statement = connection.prepareStatement(SAVE_PASSENGER, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, passenger.getName());
            statement.setString(2, passenger.getPhone());
            statement.setInt(3, passenger.getAddress().getId());
            statement.executeUpdate();
            try (ResultSet genId = statement.getGeneratedKeys()) {
                if (genId.next()) {
                    passenger.setId(genId.getInt(1));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return passenger;
    }

    @Override
    public Passenger update(Passenger passenger) {
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE_PASSENGER, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, passenger.getName());
            statement.setString(2, passenger.getPhone());
            statement.setInt(3, passenger.getAddress().getId());
            statement.setInt(4, passenger.getId());
            statement.executeUpdate();
            try (ResultSet genId = statement.getGeneratedKeys()) {
                if (genId.next()) {
                    passenger.setId(genId.getInt(1));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return passenger;
    }

    @Override
    public void delete(int passengerId) {
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE_PASSENGER, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, passengerId);
            Passenger byId = getById(passengerId);
            statement.executeUpdate();
            addressDao.delete(byId.getAddress().getId());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
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
