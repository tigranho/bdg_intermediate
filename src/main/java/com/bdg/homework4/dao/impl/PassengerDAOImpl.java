package com.bdg.homework4.dao.impl;

import com.bdg.homework4.dao.PassengerDAO;
import com.bdg.homework4.entity.Passenger;
import com.bdg.homework4.exception.NotFoundException;
import com.bdg.homework4.utils.connect.ConnectToDb;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * this class is responsible for crud operations with Passenger entity
 */

public class PassengerDAOImpl extends ConnectToDb implements PassengerDAO {
    Connection connection = getConnection();

    /**
     *
     * @param id by this param we can find and get Passenger
     * @return passenger that we found
     * @throws SQLException for PreparedStatement
     * @throws NotFoundException if incorrect id we pass
     */
    @Override
    public Passenger getById(int id) throws SQLException,NotFoundException{
        PreparedStatement preparedStatement = null;
        String sql = "select *  from passengers where id = ?";
        Passenger passenger = new Passenger();
        try {
            preparedStatement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.first()  || id <= 0){
                throw new NotFoundException("incorrect id");
            }else {
                passenger.setId(resultSet.getInt("id"));
                passenger.setName(resultSet.getString("name"));
                passenger.setPhone(resultSet.getString("phone"));
                passenger.setAddress(resultSet.getInt("address_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return passenger;
    }

    /**
     *
     * @return list of Passengers
     * @throws SQLException for PreparedStatement
     */
    @Override
    public Set<Passenger> getAll() throws SQLException{
        Set<Passenger> passengerSet = new HashSet<>();
        String sql = "select * from passengers";
        Statement statement = null;
        try{
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                Passenger passenger = new Passenger();
                passenger.setId(rs.getInt("id"));
                passenger.setName(rs.getString("name"));
                passenger.setPhone(rs.getString("phone"));
                passenger.setAddress(rs.getInt("address_id"));
                passengerSet.add(passenger);

           }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return passengerSet;
    }
    /**
     *
     * @param page count started which we we will get Passengers
     * @param perPage this is count we want to see
     * @param sort vy what we want to sort
     * @return Set of companies
     */

    @Override
    public Set<Passenger> get(int page, int perPage, String sort) {
        PreparedStatement preparedStatement = null;
        Set<Passenger> passengerSet = new HashSet<>();
        String sql = "select * from passengers order by ? limit ? offset ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, sort);
            preparedStatement.setInt(2, page);
            preparedStatement.setInt(3, perPage);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Passenger passenger = new Passenger();
                passenger.setId(rs.getInt(1));
                passenger.setName(rs.getString(2));
                passenger.setPhone(rs.getString(3));
                passenger.setAddress(rs.getInt(4));
                passengerSet.add(passenger);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return passengerSet;
    }

    /**
     *
     * @param passenger we want to save
     * @return saved passenger
     * @throws SQLException for PreparedStatement
     */
    @Override
    public Passenger save(Passenger passenger) throws SQLException{
        PreparedStatement preparedStatement = null;
        Passenger passenger1 = new Passenger();
        String sql = "insert into passengers (name,phone, address_id) values(?,?,?)";
        try{
            preparedStatement = connection.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            preparedStatement.setString(1, passenger.getName());
            preparedStatement.setString(2,passenger.getPhone());
            preparedStatement.setInt(3, passenger.getAddress());
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.executeQuery("select * from passengers");
            rs.last();

            passenger1.setId(rs.getInt("id"));
            passenger1.setName(rs.getString("name"));
            passenger1.setPhone(rs.getString("phone"));
            passenger1.setAddress(rs.getInt("address_id"));
        }catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return passenger1;
    }

    /**
     *
     * @param  id we want  to update
     * @throws SQLException for preparedStatement
     */

    @Override
    public void delete(int id) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "delete from passengers where id = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    /**
     *
     * @param tripNumber
     * @return
     * @throws SQLException
     */
    @Override
    public List<Passenger> getPassengersOfTrip(int tripNumber) throws SQLException {
       List<Passenger> passengerList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        String sql = "select * from pass_trip where trip_id = ?";
        try {
            List<Integer> list = new ArrayList<>();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, tripNumber);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int pass_id = rs.getInt(1);
                 list.add(pass_id);
            }
            String sql1 = "select * from passengers where id = ?";
            for(int i : list){
                preparedStatement = connection.prepareStatement(sql1);
                preparedStatement.setInt(1,i);
                ResultSet resultSet = preparedStatement.executeQuery();
                resultSet.next();
                Passenger p = new Passenger(resultSet.getString(2),
                        resultSet.getString(3),resultSet.getInt(4));
                p.setId(resultSet.getInt(1));
                passengerList.add(p);

            }
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return passengerList;
    }

}
