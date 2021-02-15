package com.bdg.homework4.dao.impl;

import com.bdg.homework4.dao.TripDAO;
import com.bdg.homework4.entity.Company;
import com.bdg.homework4.entity.Trip;
import com.bdg.homework4.exception.NotFoundException;
import com.bdg.homework4.utils.connect.ConnectToDb;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * this class is responsible for crud operations with Trip entity
 */
public class TripDAOImpl extends ConnectToDb implements TripDAO {
    Connection connection = getConnection();

    /**
     *
     * @param id by this param we can find and get Trip
     * @return trip that we found
     * @throws SQLException for PreparedStatement
     * @throws NotFoundException if incorrect id we pass
     */

    @Override
    public Trip getById(int id) throws SQLException{
        PreparedStatement preparedStatement = null;
        String sql = "select * from trip where id = ?";
        Trip trip = new Trip();
        try {
            preparedStatement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.first() || id <= 0) {
                throw new NotFoundException("incorrect id");
            } else {
                LocalDateTime time_in = resultSet.getTimestamp("time_in").toLocalDateTime();
                LocalDateTime time_out = resultSet.getTimestamp("time_out").toLocalDateTime();
                trip.setId(resultSet.getInt(1));
                trip.setTime_in(time_in);
                trip.setTime_in(time_out);
                trip.setTown_from(resultSet.getString("town_from"));
                trip.setTown_to(resultSet.getString("town_to"));
                preparedStatement = connection.prepareStatement("select * from company where id = ?");
                preparedStatement.setInt(1, resultSet.getInt("company_id"));
                ResultSet resultSet1 = preparedStatement.executeQuery();
                resultSet1.next();
                Company company = new Company();
                company.setId(resultSet1.getInt("id"));
                company.setName(resultSet1.getString("name"));
                company.setDate(resultSet1.getDate("found_date"));
                trip.setCompany(company);
            }
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
        return trip;
    }

    /**
     *
     * @return list of Trips
     * @throws SQLException for PreparedStatement
     */
    @Override
    public Set<Trip> getAll() throws SQLException {
        Set<Trip> tripSet = new HashSet<>();
        String sql = "select * from trip";
        Statement statement = null;
        PreparedStatement statement1 = connection.prepareStatement("select * from company where id = ?");

        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Trip trip = new Trip();
                LocalDateTime time_in = rs.getTimestamp("time_in").toLocalDateTime();
                LocalDateTime time_out = rs.getTimestamp("time_out").toLocalDateTime();
                trip.setId(rs.getInt(1));
                trip.setTime_in(time_in);
                trip.setTime_out(time_out);
                trip.setTown_from(rs.getString("town_from"));
                trip.setTown_to(rs.getString("town_to"));
                Company company = new Company();
                statement1.setInt(1,rs.getInt("company_id"));
                ResultSet resultSet1 = statement1.executeQuery();
                resultSet1.next();
                company.setId(resultSet1.getInt("id"));
                company.setName(resultSet1.getString("name"));
                company.setDate(resultSet1.getDate("found_date"));
                trip.setCompany(company);
                tripSet.add(trip);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if(statement1 != null){
                statement1.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return tripSet;
    }
    /**
     *
     * @param page count started which we we will get Trips
     * @param perPage this is count we want to see
     * @param sort vy what we want to sort
     * @return Set of trips
     */

    @Override
    public Set<Trip> get(int page, int perPage, String sort) throws SQLException{
        PreparedStatement preparedStatement = null;
        PreparedStatement statement1 = connection.prepareStatement("select * from company where id = ?");
        Set<Trip> tripSet = new HashSet<>();
        String sql = "select * from trip order by ? limit ? offset ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, sort);
            preparedStatement.setInt(2, page);
            preparedStatement.setInt(3, perPage);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Trip trip = new Trip();
                LocalDateTime time_in = rs.getTimestamp("time_in").toLocalDateTime();
                LocalDateTime time_out = rs.getTimestamp("time_out").toLocalDateTime();
                trip.setTime_in(time_in);
                trip.setTime_out(time_out);
                trip.setTown_from(rs.getString("town_from"));
                trip.setTown_to(rs.getString("town_to"));
                Company company = new Company();
                statement1.setInt(1, rs.getInt("company_id"));
                ResultSet resultSet1 = statement1.executeQuery();
                resultSet1.next();
                company.setId(resultSet1.getInt("id"));
                company.setName(resultSet1.getString("name"));
                company.setDate(resultSet1.getDate("found_date"));
                trip.setCompany(company);
                tripSet.add(trip);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if(statement1 != null){
                statement1.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return tripSet;
    }
    /**
     *
     * @param trip we want to save
     * @return saved trip
     * @throws SQLException for PreparedStatement
     */

    @Override
    public Trip save(Trip trip) throws SQLException{
        PreparedStatement preparedStatement = null;
        Trip trip1 = new Trip();
        String sql = "insert into trip (time_in, time_out, town_from, town_to, company_id) values(?,?,?,?,?)";
        try{
            preparedStatement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            LocalDateTime time_in = trip.getTime_in();
            LocalDateTime time_out = trip.getTime_out();
            preparedStatement.setObject(1,time_in);
            preparedStatement.setObject(2,time_out);
            preparedStatement.setString(3,trip.getTown_from());
            preparedStatement.setObject(4,trip.getTown_to());
            preparedStatement.setInt(5,trip.getCompany().getId());
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.executeQuery("select * from trip");
            rs.last();
            trip1.setId(rs.getInt(1));
            LocalDateTime time_in1 = rs.getTimestamp("time_in").toLocalDateTime();
            LocalDateTime time_out1 = rs.getTimestamp("time_out").toLocalDateTime();
            trip1.setTime_in(time_in1);
            trip1.setTime_out(time_out1);
            trip1.setTown_from(rs.getString("town_from"));
            trip1.setTown_to(rs.getString("town_to"));
            preparedStatement = connection.prepareStatement("select * from company where id = ?");
            preparedStatement.setInt(1,rs.getInt("company_id"));
             rs  = preparedStatement.executeQuery();
             rs.next();
            Company company = new Company();
            company.setId(rs.getInt(1));
            company.setName(rs.getString("name"));
            company.setDate(rs.getDate("found_date"));
            trip1.setCompany(company);

        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(preparedStatement != null){
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return trip1;
    }

    /**
     *
     * @param trip trip which will be updated
     * @return updated trip
     * @throws SQLException for
     */

    @Override
    public Trip update(Trip trip) throws SQLException {
        PreparedStatement preparedStatement = null;
        Trip trip1 = new Trip();
        String sql = "update trip set time_in = ?, time_out = ?, town_from = ?, town_to = ?,company_id = ? where id = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            LocalDateTime time_in = trip.getTime_in();
            LocalDateTime time_out = trip.getTime_out();
            preparedStatement.setObject(1, time_in);
            preparedStatement.setObject(2, time_out);
            preparedStatement.setString(3, trip.getTown_from());
            preparedStatement.setObject(4, trip.getTown_to());
            preparedStatement.setInt(5, trip.getCompany().getId());
            preparedStatement.setInt(6, trip.getId());
            preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement("select  * from trip where id = ?");
            preparedStatement.setInt(1, trip.getId());
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
            trip1.setId(rs.getInt(1));
            LocalDateTime time_in1 = rs.getTimestamp("time_in").toLocalDateTime();
            LocalDateTime time_out1 = rs.getTimestamp("time_out").toLocalDateTime();
            trip1.setTime_in(time_in1);
            trip1.setTime_out(time_out1);
            trip1.setTown_from(rs.getString("town_from"));
            trip1.setTown_to(rs.getString("town_to"));

            preparedStatement = connection.prepareStatement("select * from company where id = ?");
            preparedStatement.setInt(1, rs.getInt("company_id"));
            rs = preparedStatement.executeQuery();
            rs.next();
            Company company = new Company();
            company.setId(rs.getInt(1));
            company.setName(rs.getString("name"));
            company.setDate(rs.getDate("found_date"));
            trip1.setCompany(company);


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
        return trip1;
    }

    /**
     *
     * @param  tripId we want  to update
     * @throws SQLException for preparedStatement
     */
    @Override
    public void delete(int tripId) throws SQLException {
        String sql = "delete from trip where id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, tripId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

}
