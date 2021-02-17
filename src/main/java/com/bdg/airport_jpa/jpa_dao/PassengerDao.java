package com.bdg.airport_jpa.jpa_dao;

import com.bdg.airport_jpa.model.Passenger;

import java.util.List;

public interface PassengerDao {
    public void persist(Passenger entityPassenger);

    public void update(Passenger entityPassenger, int id);

    public Passenger findById(int id);

    public void delete(int id);

    public List<Passenger> findAll();

}
