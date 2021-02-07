package com.bdg.ams.repo.dao.daoimpl;

import com.bdg.ams.exception.DatabaseException;
import com.bdg.ams.model.Address;
import com.bdg.ams.model.Company;
import com.bdg.ams.model.Passenger;
import com.bdg.ams.model.Trip;
import com.bdg.ams.repo.dao.AddressDao;
import com.bdg.ams.repo.dao.PassengerDao;
import com.bdg.ams.service.AddressService;
import com.bdg.ams.util.Convert;
import com.bdg.ams.util.DatabaseConnectionFactory;

import java.sql.*;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class PassengerDaoImpl implements PassengerDao {

    private final static AddressDao addressDao = new AddressDaoImpl();
    ;


    private static Passenger toPassenger(ResultSet resultSet) throws SQLException, DatabaseException {
        Passenger passenger = new Passenger();
        passenger.setId(resultSet.getInt("id"));
        passenger.setName(resultSet.getString("name"));
        passenger.setPhone(resultSet.getString("phone"));
        passenger.setAddress(addressDao.getById(resultSet.getInt("address_id")).orElseGet(Address::new));
        return passenger;
    }

    @Override
    public Optional<Passenger> getById(long id) throws DatabaseException {
        try (Connection connection = DatabaseConnectionFactory.
                getInstance().openConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(AsmConst.GET_PASSENGER_BY_ID)) {

            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return Optional.of(PassengerDaoImpl.toPassenger(resultSet));
                }
            }
        } catch (SQLException | DatabaseException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }


    @Override
    public Set<Passenger> getAll() {
        return null;
    }

    @Override
    public Set<Passenger> get(int page, int perPage, String sort) {
        return null;
    }

    @Override
    public Passenger save(Passenger passenger) {
        try (Connection connection = DatabaseConnectionFactory.
                getInstance().openConnection();
             PreparedStatement preparedStatement = connection.
                     prepareStatement(AsmConst.SAVE_PASSENGER, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, passenger.getName());
            preparedStatement.setString(2, passenger.getPhone());
            preparedStatement.setInt(3, passenger.getAddress().getId());

            preparedStatement.executeUpdate();
            try (ResultSet genId = preparedStatement.getGeneratedKeys()) {
                if (genId.next()) {
                    passenger.setId(genId.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return passenger;

    }


    @Override
    public Passenger update(Passenger passenger) {
        return null;
    }

    @Override
    public void delete(long passengerId) {

    }

    @Override
    public List<Passenger> getPassengersOfTrip(long tripNumber) {
        return null;
    }

    @Override
    public void registerTrip(Trip trip, Passenger passenger) {

    }

    @Override
    public void cancelTrip(long passengerId, long tripNumber) {

    }
}
