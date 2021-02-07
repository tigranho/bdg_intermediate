package com.bdg.airport.dao_impl;

import com.bdg.airport.dao.DaoAddress;
import com.bdg.airport.jdbc.JDBC;
import com.bdg.airport.model.Address;
import com.bdg.airport.util.ReadDataFromFile;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static com.bdg.airport.util.ReadDataFromFile.readFile;

public class AddressImpl implements DaoAddress {
    private final static String DELETE_QUERY = "DELETE FROM airport.address WHERE  id=?";
    private final static String UPDATE_QUERY = "UPDATE airport.address SET country = ?, city = ? WHERE id = ?";
    private final static String SAVE_QUERY = "INSERT INTO airport.address (country, city)" + " values (?, ?)";
    private final static String SAVE_ALL_FROM_FILE_QUERY = " INSERT INTO airport.address (country, city)" + " values (?, ?)";
    private final static String CREATE_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS airport.address (" + "id INT AUTO_INCREMENT NOT NULL," + "country VARCHAR(255) NOT NULL," + "city VARCHAR(255)NOT NULL," + "PRIMARY KEY (id))";
    private final static String GET_ADDRESS_BY_ID = "SELECT * FROM airport.address WHERE id=?";
    private final static String GET_ID = "SELECT id from airport.address";
    Connection conn;
    PreparedStatement preparedStatement = null;
    List<String> list;

    {
        try {
            conn = DriverManager.getConnection(JDBC.JdbcInit.DB_URL, JDBC.JdbcInit.USER, JDBC.JdbcInit.PASS);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    @Override
    public Address getAddress(int id) {

        Address address = null;
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(GET_ADDRESS_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                address = new Address();
                address.setId(resultSet.getInt(1));
                address.setCountry(resultSet.getString(2));
                address.setCity(resultSet.getString(3));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return address;
    }

    @Override
    public void save(Address address) {
        try {
            preparedStatement = conn.prepareStatement(SAVE_QUERY);
            preparedStatement.setString(1, address.getCountry());
            preparedStatement.setString(2, address.getCity());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveAddressFromFile() {
        Address address = new Address();
        list = new ArrayList<>();
        list = (readFile(ReadDataFromFile.PATH_PASSENGERS));
        try {
            for (int j = 1; j < list.size(); j++) {
                String[] strings = list.get(j).split(",");
                address.setCountry(strings[2]);
                address.setCity(strings[3]);
                preparedStatement = conn.prepareStatement(SAVE_ALL_FROM_FILE_QUERY);
                preparedStatement.setString(1, address.getCountry());
                preparedStatement.setString(2, address.getCity());
                preparedStatement.executeUpdate();
            }
            conn.close();
        } catch (Throwable sqlException) {
            sqlException.printStackTrace();
        }

    }

    @Override
    public void create() {
        try {
            System.out.println("Creating table address in given database...");
            PreparedStatement preparedStatement = conn.prepareStatement(CREATE_TABLE_QUERY);
            preparedStatement.executeUpdate();
            System.out.println("Created table address in given database...");
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }

    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(DELETE_QUERY);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void update(Address address) {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_QUERY);
            preparedStatement.setString(1, address.getCountry());
            preparedStatement.setString(2, address.getCity());
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

}
