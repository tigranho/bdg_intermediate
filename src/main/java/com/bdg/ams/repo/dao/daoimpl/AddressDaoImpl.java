package com.bdg.ams.repo.dao.daoimpl;

import com.bdg.ams.exception.DatabaseException;
import com.bdg.ams.model.Address;
import com.bdg.ams.repo.dao.AddressDao;
import com.bdg.ams.util.DatabaseConnectionFactory;

import java.sql.*;
import java.util.Optional;

public class AddressDaoImpl implements AddressDao {

    @Override
    public Address save(Address address) {
        try (Connection connection = DatabaseConnectionFactory.
                getInstance().openConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(AsmConst.SAVE_ADDRESS, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, address.getCountry());
            preparedStatement.setString(2, address.getCity());
            preparedStatement.executeUpdate();
            try(ResultSet genId=preparedStatement.getGeneratedKeys()){
                if (genId.next()){
                    address.setId(genId.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return address;
    }
    @Override
    public Optional<Address> getById(long id) throws DatabaseException {

        try (Connection connection = DatabaseConnectionFactory.
                getInstance().openConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(AsmConst.GET_ADDRESS_BY_ID)) {

            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return Optional.of(AddressDaoImpl.toAddress(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    private static Address toAddress(ResultSet resultSet) throws SQLException {

        Address address = new Address();
        address.setCity(resultSet.getString("city"));
        address.setCountry(resultSet.getString("country"));

        return address;
    }

}
