package com.bdg.airport_system.dao.dao_impl;

import com.bdg.airport_system.dao.AddressDao;
import com.bdg.airport_system.config.ConnectionFactory;
import com.bdg.airport_system.model.Address;
import com.bdg.airport_system.util.*;

import static com.bdg.airport_system.util.ReadFile.fromFileToList;


import java.sql.*;
import java.util.List;

public class AddressDaoImpl implements AddressDao {

    private final Connection connection = ConnectionFactory.getConnection();


    @Override
    public Address getById(int id) {
        Address address = null;
        try {
            PreparedStatement statement = connection.prepareStatement("select * from address where id=?");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()){
                address = new Address();
                address.setId(rs.getInt(1));
                address.setTown(rs.getString(2));
                address.setCountry(rs.getString(3));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return address;
    }

    @Override
    public Address save(Address address) {

        try {
            PreparedStatement statement = connection.prepareStatement("insert into address(town,country) values (?,?)", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, address.getTown());
            statement.setString(2, address.getCountry());
            statement.executeUpdate();
            try(ResultSet generateId = statement.getGeneratedKeys()){
                if (generateId.next()){
                    address.setId(generateId.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return address;
    }

    @Override
    public void writeAddressFromFileIntoDB() {
        Address address = new Address();
        List<String> addressList = fromFileToList(ReadFile.PASSENGERS_PATH);
        //String[] temp = new String[list.size()];

        try {
            for (int i = 1; i<addressList.size(); i++) {
                String[] temp = addressList.get(i).split(",");
                address.setCountry(temp[2]);
                address.setTown(temp[3]);
                PreparedStatement preparedStatement = connection.prepareStatement("insert into address(town,country) values (?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, address.getTown());
                preparedStatement.setString(2, address.getCountry());
                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
