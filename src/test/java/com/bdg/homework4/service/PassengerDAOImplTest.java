package com.bdg.homework4.service;

import com.bdg.homework4.dao.PassengerDAO;
import com.bdg.homework4.entity.Passenger;
import com.bdg.homework4.service.exception.NotFoundException;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;

public class PassengerDAOImplTest {
    PassengerDAO passengerDAO;
    @Test
    public void getById() throws SQLException {
        passengerDAO = new PassengerDAOImpl();
       // Passenger passenger = passengerDAO.getById(5);
       // Assert.assertEquals(passenger.getId(), 5);
        Exception ex = Assert.assertThrows(NotFoundException.class,() -> passengerDAO.getById(-1));
    }

    @Test
    public void save()throws SQLException{
        passengerDAO = new PassengerDAOImpl();
        Passenger passenger = new Passenger();
        passenger.setAddress(21);
        passenger.setPhone("147-895-8965");
        passenger.setName("neysha");
        Passenger passenger1 = passengerDAO.save(passenger);
        Assert.assertEquals(passenger1.getAddress(),passenger.getAddress());
    }
}
