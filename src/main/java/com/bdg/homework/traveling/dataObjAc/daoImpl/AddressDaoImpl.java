package com.bdg.homework.traveling.dataObjAc.daoImpl;

import com.bdg.homework.traveling.connection.DbConnection;
import com.bdg.homework.traveling.dataObjAc.daoInterfaces.AddressDao;
import com.bdg.homework.traveling.model.Address;

import java.sql.*;

public class AddressDaoImpl implements AddressDao {
    @Override
    public Address getById(int addressID) {
        Address returnedAddress = new Address();
        try(Connection connection= new DbConnection().op()){

            PreparedStatement statement = connection.prepareStatement("select * from address where id=?");
            statement.setInt(1,  addressID );


            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                returnedAddress.setId(resultSet.getInt("id"));
                returnedAddress.setCountry(resultSet.getString("country"));
                returnedAddress.setCity(resultSet.getString("city"));
                return returnedAddress;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return returnedAddress;
    }



    @Override
    public Address saveAddress(Address address) {
     Address currentAddress= new Address();
        try ( Connection connection =  new DbConnection().op();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO address (country,city) values (?,?)") ) {
        statement.setString(1, address.getCountry());
        statement.setString(2, address.getCity());
        statement.executeUpdate();

            try (ResultSet genId = statement.executeQuery("SELECT * FROM address")) {
              genId.next();
              currentAddress.setId(genId.getInt("id"));
              currentAddress.setCountry(genId.getString("country"));
              currentAddress.setCity(genId.getString("city"));
              }

        } catch (Exception x) {
           x.printStackTrace();

        }
      return currentAddress ;


    }
}
