package com.bdg.homework4.dao;

import com.bdg.homework4.entity.Passenger;
import com.bdg.homework4.entity.Trip;
import com.bdg.homework4.service.exception.NotFoundException;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public interface PassengerDAO {
    Passenger getById(int id) throws SQLException, NotFoundException;
    Set<Passenger> getAll() throws SQLException;
    Set<Passenger> get(int page, int perPage,String sort);
    Passenger save(Passenger passenger)throws SQLException;
    void delete(int id)throws SQLException;
    List<Passenger> getPassengersOfTrip(int tripNumber) throws SQLException;


}
