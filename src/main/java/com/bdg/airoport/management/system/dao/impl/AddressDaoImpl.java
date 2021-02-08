package com.bdg.airoport.management.system.dao.impl;

import com.bdg.airoport.management.system.connections.DbConnection;
import com.bdg.airoport.management.system.model.Address;
import com.bdg.airoport.management.system.dao.AddressDao;

import java.sql.*;

public class AddressDaoImpl implements AddressDao {

    private final String GET_ADDRESS_BY_ID = "select * from address where id=?";
    private final String SAVE_ADDRESS = "insert  into address(country,city) values (?,?)";
    private final String DELETE_PASSENGER = "delete from address where  id=?";
    private final Connection connection = DbConnection.getInstance().getConnection();

    @Override
    public Address getById(int id) {
        Address address = null;
        try {
            PreparedStatement statement = connection.prepareStatement(GET_ADDRESS_BY_ID);
            statement.setInt(1,id);
            ResultSet set = statement.executeQuery();
            if (set.next()){
                address = new Address();
                address.setId(set.getInt(1));
                address.setCity(set.getString(2));
                address.setCountry(set.getString(3));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return address;
    }

    @Override
    public Address save(Address address) {
        try {
            PreparedStatement statement = connection.prepareStatement(SAVE_ADDRESS, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, address.getCity());
            statement.setString(2, address.getCountry());
            int rows = statement.executeUpdate();
            try(ResultSet genId=statement.getGeneratedKeys()){
                if (genId.next()){
                    address.setId(genId.getInt(1));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(int addressId) {
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE_PASSENGER, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1,addressId);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}
