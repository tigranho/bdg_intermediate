package com.bdg.airportSystem.DAO;

import com.bdg.airportSystem.config.ConnectionFactory;
import com.bdg.airportSystem.model.Address;
import com.bdg.airportSystem.model.Passenger;
import com.bdg.airportSystem.model.Trip;
import com.bdg.airportSystem.util.ReadFile;

import java.sql.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.bdg.airportSystem.util.ReadFile.fromFileToList;

public class PassengerDaoImpl implements PassengerDao{

    private final Connection connection = ConnectionFactory.getConnection();
    private final AddressDao addressDao = new AddressDaoImpl();



    @Override
    public Passenger getById(int id) {
        Passenger passenger = null;
        try {
            PreparedStatement statement = connection.prepareStatement("select * from passenger where id=?");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                passenger = new Passenger();
                passenger.setId(rs.getInt(1));
                passenger.setName(rs.getString(2));
                passenger.setPhone(rs.getString(3));
                passenger.setAddress(addressDao.getById(rs.getInt(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return passenger;
    }

    @Override
    public Set<Passenger> getAll() {
        Passenger passenger = null;
        Set<Passenger> passengers = new HashSet<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from passenger");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                passenger = new Passenger();
                passenger.setId(rs.getInt(1));
                passenger.setName(rs.getString(2));
                passenger.setPhone(rs.getString(3));
                passenger.setAddress(addressDao.getById(rs.getInt(4)));
                passengers.add(passenger);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return passengers;
    }

    @Override
    public Set<Passenger> get(int page, int perPage, String sort) {
        return null;
    }

    @Override
    public Passenger save(Passenger passenger) {
        try {
            PreparedStatement statement = connection.prepareStatement("insert  into passenger(name,phone,address) values (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, passenger.getName());
            statement.setString(2, passenger.getPhone());
            statement.setInt(3, passenger.getAddress().getId());
            statement.executeUpdate();
            try (ResultSet generateID = statement.getGeneratedKeys()) {
                if (generateID.next()) {
                    passenger.setId(generateID.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return passenger;
    }

    @Override
    public Passenger update(Passenger passenger) {
        try {
            PreparedStatement statement = connection.prepareStatement("update passenger set name=?,phone=?,address=?  where id=?", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, passenger.getName());
            statement.setString(2, passenger.getPhone());
            statement.setInt(3, passenger.getAddress().getId());
            statement.setInt(4, passenger.getId());
            statement.executeUpdate();
            try (ResultSet generateId = statement.getGeneratedKeys()) {
                if (generateId.next()) {
                    passenger.setId(generateId.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return passenger;
    }

    @Override
    public void delete(int passengerId) {
        try {
            PreparedStatement statement = connection.prepareStatement("delete from passenger where  id=?", Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1,passengerId);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writePassengersFromFileToDB() {
        Passenger passenger = new Passenger();
        List<String> passengersList = fromFileToList(ReadFile.PASSENGERS_PATH);
        try {
            for (int i = 1; i<passengersList.size(); i++) {
                String[] passengersArray = passengersList.get(i).split(",");
                passenger.setName(passengersArray[0]);
                passenger.setPhone(passengersArray[1]);

                Address address = new Address();
                address.setTown(passengersArray[3]);
                address.setCountry(passengersArray[2]);


                PreparedStatement statement = connection.prepareStatement("insert  into passenger(name,phone,address) values (?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
                statement.setString(1, passenger.getName());
                statement.setString(2, passenger.getPhone());
                statement.setString(3, address.getTown()  + ", " + address.getCountry());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

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
