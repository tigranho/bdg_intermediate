package com.bdg.homework.airport.repository;

import com.bdg.homework.airport.configuration.DbConnection;
import com.bdg.homework.airport.model.Address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressDaoImpl implements AddressDao {

    private final static String GET_ADDRESS_BY_ID = "select * from address where id=?";
    private Connection connection = DbConnection.getInstance().getConnection();


    @Override
    public Address getById(int id) {
        Address address = null;
        try {
            PreparedStatement statement = connection.prepareStatement(GET_ADDRESS_BY_ID);
            statement.setInt(1, id);
            ResultSet set = statement.executeQuery();
            if (set.next()) {
                address = new Address();
                address.setId(set.getInt(1));
                address.setCountry(set.getString(2));
                address.setCity(set.getString(3));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return address;
    }
}
