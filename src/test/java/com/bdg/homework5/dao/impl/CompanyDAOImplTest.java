package com.bdg.homework5.dao.impl;

import com.bdg.homework5.dao.CompanyDAO;
import com.bdg.homework5.entity.Company;
import com.bdg.homework5.entity.Passenger;
import com.bdg.homework5.entity.Trip;
import org.junit.Assert;
import org.junit.Test;


import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public class CompanyDAOImplTest {
    CompanyDAO companyDAO;

    @Test
    public void getById(){
        companyDAO = new CompanyDAOImpl();
        Company trip = companyDAO.getById(1);
        Assert.assertEquals(1, (int) trip.getId());

    }

    @Test
    public void save(){
        companyDAO = new CompanyDAOImpl();
        Company company = new Company("Nor", Date.valueOf("2017-11-15"));
        Company company1 = companyDAO.save(company);
        Assert.assertEquals(company.getName(),company1.getName());
    }

}
