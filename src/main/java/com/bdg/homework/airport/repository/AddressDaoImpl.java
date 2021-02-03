package com.bdg.homework.airport.repository;

import com.bdg.homework.airport.configuration.DbConnection;
import com.bdg.homework.airport.model.Address;

import java.sql.*;

public class AddressDaoImpl implements AddressDao {

    private final static String GET_ADDRESS_BY_ID = "select * from address where id=?";
    private final static String SAVE_ADDRESS = "insert  into address(country,city) values (?,?)";
    private final Connection connection = DbConnection.getInstance().getConnection();


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

    @Override
    public Address save(final Address address) {
        try {
            PreparedStatement statement = connection.prepareStatement(SAVE_ADDRESS, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, address.getCountry());
            statement.setString(2, address.getCity());
            int rows = statement.executeUpdate();
           try(ResultSet genId=statement.getGeneratedKeys()){
               if (genId.next()){
                   address.setId(genId.getInt(1));
               }
           }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return address;
    }
}
