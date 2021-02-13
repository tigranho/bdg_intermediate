package com.bdg.homework.traveling.dataObjAc.daoImpl;

import com.bdg.homework.traveling.dataObjAc.daoInterfaces.PassengersDao;
import com.bdg.homework.traveling.dataObjAc.daoInterfaces.TripDao;
import com.bdg.homework.traveling.model.Passenger;

import java.util.List;
import java.util.Set;

public class PassengersDaoImpl implements PassengersDao {
    @Override
    public Passenger getById(long id) {
        return null;
    }

    @Override
    public Set<Passenger> getAll() {
        return null;
    }

    @Override
    public Set<Passenger> get(int page, int perPage, String sort) {
        return null;
    }

    @Override
    public Passenger save(Passenger passenger) {
        return null;
    }

    @Override
    public Passenger update(Passenger passenger) {
        return null;
    }

    @Override
    public void delete(long passengerId) {

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
