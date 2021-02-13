package com.bdg.homework.traveling.dataObjAc.daoImpl;

import com.bdg.homework.traveling.connection.DbConnection;
import com.bdg.homework.traveling.dataObjAc.daoInterfaces.AddressDao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddressDaoImpl implements AddressDao {
    @Override
    public AddressDao getById(int addressID) {
        return null;
    }

    @Override
    public AddressDao getAll() {
        return null;
    }

    @Override
    public AddressDao saveAddress(AddressDao address) {

        try (final Connection connection = new DbConnection().getInstance().openConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO addres "))  {


        } catch (Exception x) {


        }


        return null;
    }
}
