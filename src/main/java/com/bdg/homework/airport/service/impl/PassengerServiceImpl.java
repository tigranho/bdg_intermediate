package com.bdg.homework.airport.service.impl;

import com.bdg.homework.airport.enums.impl.PassengerErrorCode;
import com.bdg.homework.airport.excpetions.impl.PassengerException;
import com.bdg.homework.airport.model.Passenger;
import com.bdg.homework.airport.model.Trip;
import com.bdg.homework.airport.repository.PassengerDao;
import com.bdg.homework.airport.repository.impl.PassengerDaoImpl;
import com.bdg.homework.airport.service.PassengerService;

import java.util.List;
import java.util.Set;

public class PassengerServiceImpl implements PassengerService {

    private PassengerDao passengerDao;

    public PassengerServiceImpl() {
        passengerDao = new PassengerDaoImpl();
    }


    @Override
    public Passenger save(final Passenger passenger) throws PassengerException {
        if (passenger == null) {
            throw new PassengerException(PassengerErrorCode.PASSENGER_IS_EMPTY);
        }
        return passengerDao.save(passenger);
    }

    @Override
    public Passenger getById(final int id) throws PassengerException {
        if (id <= 0) {
            throw new PassengerException(PassengerErrorCode.PASSENGER_NOT_VALID_ID);
        }
        Passenger passengerById = passengerDao.getById(id);
        if (passengerById == null) {
            throw new PassengerException(PassengerErrorCode.PASSENGER_NOT_FOUND);
        }
        return passengerById;
    }

    @Override
    public Set<Passenger> getAll() {
        Set<Passenger> allPassenger = passengerDao.getAll();
        return allPassenger;
    }

    @Override
    public Set<Passenger> get(int page, int perPage, String sort) {
        return null;
    }

    @Override
    public Passenger update(final Passenger passenger) throws PassengerException {
        if (passenger == null) {
            throw new PassengerException(PassengerErrorCode.PASSENGER_IS_EMPTY);
        }
        return passengerDao.update(passenger);
    }

    @Override
    public void delete(final int passengerId) throws PassengerException {
        if (passengerId <= 0) {
            throw new PassengerException(PassengerErrorCode.PASSENGER_NOT_VALID_ID);
        }
        Passenger passengerById = passengerDao.getById(passengerId);
        if (passengerById == null) {
            throw new PassengerException(PassengerErrorCode.PASSENGER_NOT_FOUND);
        }
        passengerDao.delete(passengerId);
    }

    @Override
    public List<Passenger> getPassengersOfTrip(long tripNumber) {
        return null;
    }

    @Override
    public void registerTrip(Trip trip, Passenger passenger) {

    }

    @Override
    public void cancelTrip(long passengerId, long tripNumber) {

    }
}
