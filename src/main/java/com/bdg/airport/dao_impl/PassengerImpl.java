package com.bdg.airport.dao_impl;

import com.bdg.airport.dao.DaoAddress;
import com.bdg.airport.dao.DaoPassenger;
import com.bdg.airport.jdbc.JDBC;
import com.bdg.airport.model.Address;
import com.bdg.airport.model.Passenger;
import com.bdg.airport.model.Trip;
import com.bdg.airport.util.ReadDataFromFile;
import java.sql.*;
import java.util.*;

import static com.bdg.airport.util.ReadDataFromFile.readFile;

public class PassengerImpl implements DaoPassenger {
    DaoAddress daoAddress=new AddressImpl();
    List<String> list = null;
    private final static String DELETE_QUERY = "DELETE FROM airport.passenger WHERE  id=?";
    private final static String UPDATE_QUERY = "UPDATE airport.passenger SET name = ?, phone = ?,addressId = ? WHERE id = ?";
    private final static String SAVE_QUERY = "INSERT INTO airport.passenger (name, phone,addressId)" + " values (?, ?, ?)";
    private final static String SAVE_ALL_FROM_FILE_QUERY = " INSERT INTO airport.passenger (name, phone,addressId)" + " values (?, ?, ?)";
    private final static String CREATE_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS airport.passenger (" + "id INT AUTO_INCREMENT NOT NULL," + "name VARCHAR(255) NOT NULL," + "phone VARCHAR(1000)NOT NULL," + "addressId INT  NOT NULL ," + "PRIMARY KEY (id))";
    private final static String GET_ALL_PASSENGER = "SELECT * FROM airport.passenger";
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
    public Set<Passenger> getAll() {

        Passenger passenger = null;
        Set<Passenger> passengers = new TreeSet<>();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(GET_ALL_PASSENGER);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                passenger.setName(resultSet.getString(1));
                passenger.setPhone(resultSet.getString(2));
                passenger.setId(resultSet.getInt(3));
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
    public void create() {
        try {
            System.out.println("Creating table passengers in given database...");
            PreparedStatement preparedStatement = conn.prepareStatement(CREATE_TABLE_QUERY);
            preparedStatement.executeUpdate();
            System.out.println("Created table passengers in given database...");
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void savePassengersFromFile() {
        Passenger passenger = new Passenger();
        list = new ArrayList<>();
        list = (readFile(ReadDataFromFile.PATH_PASSENGERS));
        try {
            for (int j = 1; j < list.size(); j++) {
                String[] strings = list.get(j).split(",");
                passenger.setName(strings[0]);
                passenger.setPhone(strings[1]);
                preparedStatement = conn.prepareStatement(SAVE_ALL_FROM_FILE_QUERY,PreparedStatement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, passenger.getName());
                preparedStatement.setString(2, passenger.getPhone());
                preparedStatement.setInt(3,daoAddress.getAddress(j).getId());
                preparedStatement.executeUpdate();
            }
            conn.close();
        } catch (Throwable sqlException) {
            sqlException.printStackTrace();
        }
    }

    @Override
    public void save(Passenger passenger) {
        try {
            preparedStatement = conn.prepareStatement(SAVE_QUERY,Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, passenger.getName());
            preparedStatement.setString(2, passenger.getPhone());
            preparedStatement.setInt(3, passenger.getAddresId());
            preparedStatement.executeUpdate();
            try (ResultSet genId = preparedStatement.getGeneratedKeys()) {
                if (genId.next()) {
                    passenger.setId(genId.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Passenger passenger) {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_QUERY);
            preparedStatement.setString(1, passenger.getName());
            preparedStatement.setString(2, passenger.getPhone());
            preparedStatement.setInt(3, passenger.getAddresId());
            preparedStatement.setInt(4, passenger.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void delete(int passengerId) {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(DELETE_QUERY);
            preparedStatement.setInt(1, passengerId);
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
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
