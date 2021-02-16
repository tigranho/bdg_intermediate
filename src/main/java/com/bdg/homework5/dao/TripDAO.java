package com.bdg.homework5.dao;

import com.bdg.homework5.entity.Trip;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public interface TripDAO {
    Trip getById(int id);
    List<Trip> getAll();
    List<Trip> get(int page, int perPage, String sort);
    Trip save(Trip passenger);
    Trip update(Trip passenger);
    void delete(int tripId);
}
