package com.bdg.homework.traveling.dataObjAc.daoImpl;

import com.bdg.homework.traveling.connection.DbConnection;
import com.bdg.homework.traveling.dataObjAc.daoInterfaces.TripDao;
import com.bdg.homework.traveling.model.Address;
import com.bdg.homework.traveling.model.Passenger;
import com.bdg.homework.traveling.model.Trip;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TripDaoImpl implements TripDao {
    @Override
    public Trip getById(int id) {
        Trip returnedTrip = new Trip();
        try(Connection connection= new DbConnection().op()){

            PreparedStatement statement = connection.prepareStatement("select * from trip where id=?");
            statement.setInt(1,  id );


            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                returnedTrip.setId(resultSet.getInt("id"));
                returnedTrip.setTripNumber(resultSet.getInt("trip_number"));
                returnedTrip.setTown_From(resultSet.getString("town_from"));
                returnedTrip.setTown_TO(resultSet.getString("town_to"));
                returnedTrip.setTime_In(resultSet.getDate("time_in"));
                returnedTrip.setTime_Out(resultSet.getDate("time_out"));
                return returnedTrip;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return returnedTrip;
    }
    @Override
    public Trip save(Trip passenger) {

        Trip currentTrip = new Trip();
        try ( Connection connection =  new DbConnection().op();
              PreparedStatement statement = connection.prepareStatement("INSERT INTO trip (trip_number,town_from,town_to,time_in,time_out) values (?,?,?,?,?)") ) {
            statement.setInt(1, passenger.getTripNumber());
            statement.setString(2, passenger.getTown_From());
            statement.setString(3, passenger.getTown_TO());
            statement.setDate(4, passenger.getTime_In());
            statement.setDate(5, passenger.getTime_Out());
            statement.execute();

            try (ResultSet genId = statement.executeQuery("SELECT * FROM trip")) {
                genId.next();
                currentTrip.setId(genId.getInt("id"));
                currentTrip.setTripNumber(genId.getInt("trip_number"));
                currentTrip.setTown_From(genId.getString("town_from"));
                currentTrip.setTown_TO(genId.getString("town_to"));
                currentTrip.setTime_In(genId.getDate("time_in"));
                currentTrip.setTime_Out(genId.getDate("time_out"));
            }

        } catch (Exception x) {
            x.printStackTrace();

        }
        return currentTrip ;
    }
    @Override
    public Trip update(Trip passenger, int id) {
        Trip updatedTrip = new Trip();

        try(Connection connection= new DbConnection().openConnection();
            PreparedStatement preparedStatement= connection.prepareStatement("update trip set trip_number=?,town_from=?,town_to=?,time_in=?,time_out=?  where id=?") ){
            preparedStatement.setInt(1, passenger.getTripNumber());
            preparedStatement.setString(2, passenger.getTown_From());
            preparedStatement.setString(3, passenger.getTown_TO());
            preparedStatement.setDate(4, passenger.getTime_In());
            preparedStatement.setDate(5, passenger.getTime_Out());
            preparedStatement.executeUpdate();

            ResultSet resultSet= preparedStatement.executeQuery("SELECT * FROM passenger");
            if (resultSet.next()) {
                updatedTrip.setId(resultSet.getInt("id"));
                updatedTrip.setTripNumber(resultSet.getInt("trip_number"));
                updatedTrip.setTown_From(resultSet.getString("town_from"));
                updatedTrip.setTown_TO(resultSet.getString("town_to"));
                updatedTrip.setTime_In(resultSet.getDate("time_in"));
                updatedTrip.setTime_Out(resultSet.getDate("time_out"));
            }

        }catch (Exception x){
            x.printStackTrace();
        }

        return updatedTrip;
    }

    @Override
    public void delete(int tripId) {
        try (Connection connection= new DbConnection().openConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("delete from trip where  id=?")){
            preparedStatement.setLong(1, tripId);
            preparedStatement.executeUpdate();
            System.out.println("The company has been deleted " + tripId);

        }catch (Exception e){

        }
    }
    @Override
    public Set<Trip> getAll() {
        Set<Trip> trips= new HashSet<>();
        try(Connection connection= new DbConnection().openConnection();
            PreparedStatement preparedStatement= connection.prepareStatement("SELECT * FROM trip")){
            ResultSet resultSet=preparedStatement.executeQuery();
            Trip currentTrip;
            while (resultSet.next()){
                currentTrip = new Trip();
                currentTrip.setId(resultSet.getInt("id"));
                currentTrip.setTripNumber(resultSet.getInt("trip_number"));
                currentTrip.setTown_From(resultSet.getString("town_from"));
                currentTrip.setTown_TO(resultSet.getString("town_to"));
                currentTrip.setTime_In(resultSet.getDate("time_in"));
                currentTrip.setTime_Out(resultSet.getDate("time_out"));

                trips.add(currentTrip);
            }

        }catch (Exception exception){

        }
        return trips;
    }

    @Override
    public Set<Trip> get(int page, int perPage, String sort) {




        return null;
    }


    @Override
    public List<Trip> getTripsFrom(String city) {





        return null;
    }

    @Override
    public List<Trip> getTripsTo(String city) {






        return null;
    }
}
