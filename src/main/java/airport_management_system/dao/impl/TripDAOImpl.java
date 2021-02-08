package airport_management_system.dao.impl;

import airport_management_system.dao.TripDAO;
import airport_management_system.model.Company;
import airport_management_system.model.Trip;
import airport_management_system.services.PgSql;

import java.sql.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TripDAOImpl implements TripDAO {

    private void getData(Trip trip, ResultSet resultSet) throws SQLException {
        trip.setId(resultSet.getLong("id"));
        trip.setTimeIn(resultSet.getTimestamp("time_in").toLocalDateTime());
        trip.setTimeOut(resultSet.getTimestamp("time_out").toLocalDateTime());
        trip.setTownFrom(resultSet.getString("town_from"));
        trip.setTownTo(resultSet.getString("town_to"));
        trip.setCompany(new Company(resultSet.getString("name"), resultSet.getDate("found_date").toLocalDate()));
    }

    @Override
    public Trip getById(long id) {
        Trip trip = new Trip();
        String sql = "SELECT t.id, t.time_in, t.time_out, t.town_to, t.town_from, c.name, c.found_date FROM trip as t " +
                "INNER JOIN company as c " +
                "ON (t.company_id = c.id) " +
                "WHERE t.id=?";
        try (Connection cn = DriverManager.getConnection(PgSql.url, PgSql.username, PgSql.password);
             PreparedStatement stm = cn.prepareStatement(sql)) {
            stm.setLong(1, id);
            ResultSet resultSet = stm.executeQuery();

            if (resultSet.next()) {
                getData(trip, resultSet);
            }

        } catch (Exception exception) {
            System.out.println(exception);
        }
        return trip;
    }


    @Override
    public Set<Trip> getAll() {
        Set<Trip> trips = new HashSet<>();
        String sql = "SELECT t.id, t.time_in, t.time_out, t.town_to, t.town_from, c.name, c.found_date FROM trip as t " +
                "INNER JOIN company as c " +
                "ON (t.company_id = c.id) ";
        try (Connection cn = DriverManager.getConnection(PgSql.url, PgSql.username, PgSql.password);
             PreparedStatement stm = cn.prepareStatement(sql)) {
            ResultSet resultSet = stm.executeQuery();

            while (resultSet.next()) {
                Trip trip = new Trip();

                getData(trip, resultSet);

                trips.add(trip);
            }
        } catch (Exception exception) {
            System.out.println(exception);
        }
        return trips;
    }

    @Override
    public Set<Trip> get(int page, int perPage, String sort) {
        Set<Trip> trips = new HashSet<>();
        String sql = "SELECT t.id, t.time_in, t.time_out, t.town_to, t.town_from, c.name, c.found_date FROM trip as t " +
                "INNER JOIN company as c ON (t.company_id = c.id) ORDER BY t.time_in " + sort + " LIMIT ? OFFSET ?";
        try (Connection cn = DriverManager.getConnection(PgSql.url, PgSql.username, PgSql.password);
             PreparedStatement stm = cn.prepareStatement(sql)) {

            stm.setInt(1, perPage);
            stm.setInt(2, page);

            ResultSet resultSet = stm.executeQuery();

            while (resultSet.next()) {
                Trip trip = new Trip();

                getData(trip, resultSet);

                trips.add(trip);
            }

        } catch (Exception exception) {
            System.out.println(exception);
        }
        return trips;
    }

    private void setData(Trip trip, PreparedStatement stm) throws SQLException {
        stm.setTimestamp(1, Timestamp.valueOf(trip.getTimeIn()));
        stm.setTimestamp(2, Timestamp.valueOf(trip.getTimeOut()));
        stm.setString(3, trip.getTownTo());
        stm.setString(4, trip.getTownFrom());
    }
    @Override
    public Trip save(Trip trip) {
        String selectSql = "SELECT * FROM company WHERE name =?";
        String insertSql = "INSERT INTO trip (time_in, time_out, town_to, town_from, company_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection cn = DriverManager.getConnection(PgSql.url, PgSql.username, PgSql.password);
             PreparedStatement stm1 = cn.prepareStatement(selectSql);
             PreparedStatement stm2 = cn.prepareStatement(insertSql)) {

            stm1.setString(1, trip.getCompany().getName());
            ResultSet resultSet = stm1.executeQuery();
            if (resultSet.next()) {
                setData(trip, stm2);
                stm2.setLong(5, resultSet.getLong("id"));
                stm2.executeUpdate();
            } else {
                try(PreparedStatement stm3 = cn.prepareStatement("INSERT INTO company (name, found_date) VALUES (?, ?)")){
                    stm3.setString(1, trip.getCompany().getName());
                    stm3.setDate(2, Date.valueOf(trip.getCompany().getFound_date()));
                    stm3.executeUpdate();
                    resultSet = stm1.executeQuery();
                    //System.out.println(resultSet.next());
                    if(resultSet.next()){
                        setData(trip, stm2);
                        stm2.setLong(5, resultSet.getLong("id"));
                        stm2.executeUpdate();
                    }
                }
            }
        } catch (Exception exception) {
            System.out.println(exception);
        }
        return trip;
    }

    public Set<Trip> saveAll(Set<Trip> trip) {

        return null;
    }

    @Override
    public Trip update(Trip trip) {
        return null;
    }

    @Override
    public void delete(long tripId) {

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
