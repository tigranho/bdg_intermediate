package com.bdg.homework5.dao.impl;

import com.bdg.homework5.dao.TripDAO;
import com.bdg.homework5.entity.Address;
import com.bdg.homework5.entity.Company;
import com.bdg.homework5.entity.Passenger;
import com.bdg.homework5.entity.Trip;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public class TripDAOImplTest {
    TripDAO tripDAO;

    @Test
    public void getById(){
        tripDAO = new TripDAOImpl();
        Trip trip = tripDAO.getById(1);
        Assert.assertEquals(1, (int) trip.getId());
        Trip trip1 = tripDAO.getById(2);
        Assert.assertEquals(2, (int) trip1.getId());
    }

    @Test
    public void save(){
        tripDAO = new TripDAOImpl();
        Trip trip = new Trip();
        trip.setTime_in(Timestamp.valueOf("2017-11-15 15:30:14"));
        trip.setTime_out(Timestamp.valueOf("2017-11-15 20:30:14"));
        trip.setTown_from("London");
        trip.setTown_to("Liverpool");
        Company company = new Company("Nor", Date.valueOf("2014-10-14"));
        trip.setCompany(company);
        Trip trip1 = tripDAO.save(trip);
        Assert.assertEquals(trip.getId(), trip1.getId());
        Assert.assertEquals(trip.getCompany(), trip1.getCompany());
    }

    @Test
    public void update(){
        tripDAO = new TripDAOImpl();
        Trip trip = new Trip();
        trip.setId(1);
        trip.setTime_in(Timestamp.valueOf("2017-11-15 15:30:14"));
        trip.setTime_out(Timestamp.valueOf("2017-11-15 20:30:14"));
        trip.setTown_from("London");
        trip.setTown_to("Liverpool");
        Company company = new Company();
        company.setId(1);
        trip.setCompany(company);
        Trip trip1 = tripDAO.update(trip);
        Assert.assertEquals(trip.getId(), trip1.getId());
        Assert.assertEquals(trip.getCompany(), trip1.getCompany());
    }

    @Test
    public void delete(){
        tripDAO = new TripDAOImpl();
        List<Trip> passengerList = tripDAO.getAll();
        tripDAO.delete(8);
        tripDAO.delete(9);
        List<Trip> passengerList1 = tripDAO.getAll();
        Assert.assertEquals(2, passengerList.size() - passengerList1.size());
    }

}
