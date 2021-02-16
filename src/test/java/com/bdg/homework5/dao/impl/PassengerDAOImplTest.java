package com.bdg.homework5.dao.impl;

import com.bdg.homework5.dao.PassengerDAO;
import com.bdg.homework5.entity.Address;
import com.bdg.homework5.entity.Passenger;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class PassengerDAOImplTest {
    PassengerDAO passengerDAO ;

    @Test
    public void getById(){
        passengerDAO = new PassengerDAOImpl();
        Passenger passenger = passengerDAO.getById(1);
        Assert.assertEquals(1, (int) passenger.getId());
    }

    @Test
    public void save(){
        passengerDAO = new PassengerDAOImpl();
        Passenger passenger = new Passenger("Ara","Chill");
        passenger.setAddress(new Address("Armenia","Vanadzor"));
        Passenger passenger1 = passengerDAO.save(passenger);
        Assert.assertEquals(passenger.getName(), passenger1.getName());
    }

    @Test
    public void update(){
        passengerDAO = new PassengerDAOImpl();
        Passenger passenger = new Passenger("Ara","Chill");
        passenger.setAddress(new Address("Armenia","Vanadzor"));
        Passenger passenger1 = passengerDAO.update(2,passenger);
        Assert.assertEquals(passenger.getName(), passenger1.getName());
        Assert.assertEquals(passenger.getAddress(), passenger1.getAddress());

    }

    @Test
    public void delete(){
        passengerDAO = new PassengerDAOImpl();
        List<Passenger> passengerList = passengerDAO.getAll();
        passengerDAO.delete(6);
        passengerDAO.delete(7);
        List<Passenger> passengerList1 = passengerDAO.getAll();
        Assert.assertEquals(2, passengerList.size() - passengerList1.size());
    }
}
