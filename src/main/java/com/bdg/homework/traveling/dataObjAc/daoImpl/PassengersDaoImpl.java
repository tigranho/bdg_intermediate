package com.bdg.homework.traveling.dataObjAc.daoImpl;

import com.bdg.homework.traveling.connection.DbConnection;
import com.bdg.homework.traveling.dataObjAc.daoInterfaces.PassengersDao;
import com.bdg.homework.traveling.dataObjAc.daoInterfaces.TripDao;
import com.bdg.homework.traveling.model.Address;
import com.bdg.homework.traveling.model.Company;
import com.bdg.homework.traveling.model.Passenger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PassengersDaoImpl implements PassengersDao {
    @Override
    public Passenger save(Passenger passenger) {

        Passenger currentPassenger = new Passenger();
        try ( Connection connection =  new DbConnection().op();
              PreparedStatement statement = connection.prepareStatement("INSERT INTO passenger (phone_number,name) values (?,?)") ) {
            statement.setInt(1, passenger.getPhoneNumber());
            statement.setString(2, passenger.getName());
            statement.executeUpdate();

            try (ResultSet genId = statement.executeQuery("SELECT * FROM passenger")) {
                genId.next();
                currentPassenger.setId(genId.getInt("id"));
                currentPassenger.setPhoneNumber(genId.getInt("phone_number"));
                currentPassenger.setName(genId.getString("name"));
            }

        } catch (Exception x) {
            x.printStackTrace();

        }
        return currentPassenger ;
    }

    @Override
    public Passenger getById(int id) {

        Passenger returnedPassenger = new Passenger();
        try(Connection connection= new DbConnection().op()){

            PreparedStatement statement = connection.prepareStatement("select * from passenger where id=?");
            statement.setInt(1,  id );


            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                returnedPassenger.setId(resultSet.getInt("id"));
                returnedPassenger.setName(resultSet.getString("name"));
                returnedPassenger.setPhoneNumber(resultSet.getInt("phone_number"));
                return returnedPassenger;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return returnedPassenger;
    }
    @Override
    public Passenger update(Passenger passenger, int id) {
        Passenger updatedPassenger = new Passenger();

        try(Connection connection= new DbConnection().openConnection();
            PreparedStatement preparedStatement= connection.prepareStatement("update passenger set name=?,phone_number=?  where id=?") ){
            preparedStatement.setString(1, passenger.getName());
            preparedStatement.setInt(2, passenger.getPhoneNumber());
            preparedStatement.setInt(3,id);
            preparedStatement.executeUpdate();

            ResultSet resultSet= preparedStatement.executeQuery("SELECT * FROM passenger");
            if (resultSet.next()) {
                updatedPassenger.setId(resultSet.getInt("id"));
                updatedPassenger.setName(resultSet.getString("name"));
                updatedPassenger.setPhoneNumber(resultSet.getInt("phone_number"));
            }

        }catch (Exception x){
            x.printStackTrace();
        }

        return updatedPassenger;
    }

    @Override
    public void delete(long passengerId) {
        try (Connection connection= new DbConnection().openConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("delete from passenger where  id=?")){
            preparedStatement.setLong(1, passengerId);
            preparedStatement.executeUpdate();
            System.out.println("The company has been deleted " + passengerId);

        }catch (Exception e){

        }
    }
    @Override
    public Set<Passenger> getAll() {

        Set<Passenger> passengers= new HashSet<>();
        try(Connection connection= new DbConnection().openConnection();
            PreparedStatement preparedStatement= connection.prepareStatement("SELECT * FROM passenger")){
            ResultSet resultSet=preparedStatement.executeQuery();
            Passenger currentPassenger;
            while (resultSet.next()){
                currentPassenger = new Passenger();
                currentPassenger.setId(resultSet.getInt("id"));
                currentPassenger.setName(resultSet.getString("name"));
                currentPassenger.setPhoneNumber(resultSet.getInt("phone_number"));

                passengers.add(currentPassenger);
            }

        }catch (Exception exception){

        }
        return passengers;
    }

    @Override
    public Set<Passenger> get(int page, int perPage, String sort) {
        return null;
    }



    @Override
    public List<Passenger> getPassengersOfTrip(long tripNumber) {
        return null;
    }

    @Override
    public void registerTrip(TripDao trip, Passenger passenger) {

    }

    @Override
    public void cancelTrip(long passengerId, long tripNumber) {

    }
}
