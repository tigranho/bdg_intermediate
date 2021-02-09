package com.bdg.airportSystem.DAO;

import com.bdg.airportSystem.config.ConnectionFactory;
import com.bdg.airportSystem.model.Address;
import com.bdg.airportSystem.util.*;

import static com.bdg.airportSystem.util.ReadFile.fromFileToList;


import java.sql.*;
import java.util.List;

public class AddressDaoImpl implements AddressDao{

    private final static String GET_ADDRESS_BY_ID = "select * from address where id=?";
    private final static String SAVE_ADDRESS = "insert into address(town,country) values (?,?)";
    private final Connection connection = ConnectionFactory.getConnection();


    @Override
    public Address getById(int id) {
        Address address = null;
        try {
            PreparedStatement statement = connection.prepareStatement(GET_ADDRESS_BY_ID);
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
            PreparedStatement statement = connection.prepareStatement(SAVE_ADDRESS, Statement.RETURN_GENERATED_KEYS);
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
            for (String s : addressList) {
                String[] temp = s.split(",");
                address.setCountry(temp[2]);
                address.setTown(temp[3]);
                PreparedStatement preparedStatement = connection.prepareStatement(SAVE_ADDRESS);
                preparedStatement.setString(1, address.getCountry());
                preparedStatement.setString(2, address.getTown());
                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
