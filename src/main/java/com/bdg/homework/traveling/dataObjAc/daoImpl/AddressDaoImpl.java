package com.bdg.homework.traveling.dataObjAc.daoImpl;

import com.bdg.homework.traveling.connection.DbConnection;
import com.bdg.homework.traveling.dataObjAc.daoInterfaces.AddressDao;
import com.bdg.homework.traveling.model.Address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class AddressDaoImpl implements AddressDao {
    @Override
    public Address getById(int addressID) {
        return null;
    }

    @Override
    public Address getAll() {
        return null;
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
