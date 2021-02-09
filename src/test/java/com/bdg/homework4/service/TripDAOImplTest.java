package com.bdg.homework4.service;

import com.bdg.homework4.dao.TripDAO;
import com.bdg.homework4.entity.Company;
import com.bdg.homework4.entity.Trip;
import com.bdg.homework4.service.exception.NotFoundException;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class TripDAOImplTest {

    TripDAO tripDAO;
    @Test
    public void getById() throws SQLException {
        tripDAO = new TripDAOImpl();
        Trip trip = tripDAO.getById(5);
        Assert.assertEquals(trip.getId(), 5);
       // Exception ex = Assert.assertThrows(NotFoundException.class,() -> tripDAO.getById(-1));

    }

    @Test
    public void save()throws SQLException{
        tripDAO = new TripDAOImpl();
        Company company = new Company();
        company.setId(1001);
        company.setName("Lajo");
        company.setDate(Date.valueOf("2008-10-13"));
        Trip trip = new Trip();
        trip.setCompany(company);
        trip.setTime_in(LocalDateTime.now());
        trip.setTime_out(LocalDateTime.now().plusHours(10));
        trip.setTown_from("London");
        trip.setTown_to("LA");
        Trip trip1 = tripDAO.save(trip);
        Assert.assertEquals(trip1.getTown_from(),trip.getTown_from());
    }
}
