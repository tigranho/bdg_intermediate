package com.bdg.homework4.dao;

import com.bdg.homework4.entity.Trip;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public interface TripDAO {
    Trip getById(int id) throws SQLException;
    Set<Trip> getAll() throws SQLException;
    Set<Trip> get(int page, int perPage, String sort)throws SQLException;
    Trip save(Trip passenger) throws SQLException;
    Trip update(Trip passenger) throws SQLException;
    void delete(int tripId)throws SQLException;

}
