package com.bdg.homework4.service;

import com.bdg.homework4.dao.CompanyDAO;
import com.bdg.homework4.dao.impl.CompanyDAOImpl;
import com.bdg.homework4.entity.Company;
import com.bdg.homework4.exception.NotFoundException;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Date;
import java.sql.SQLException;

public class CompanyDAOImplTest {
    CompanyDAO companyDAO;

    @Test
    public void getById() throws SQLException {
        companyDAO = new CompanyDAOImpl();
        /*Company company = companyDAO.getById(5);
        Assert.assertEquals(company.getId(), 5);*/
        Exception ex = Assert.assertThrows(NotFoundException.class,() -> companyDAO.getById(-1));

    }

    @Test
    public void save()throws SQLException{
        companyDAO = new CompanyDAOImpl();
        Company company = new Company();
        company.setName("Lajo");
        company.setDate(Date.valueOf("2008-10-13"));
        Company company1 = companyDAO.save(company);
        Assert.assertEquals(company.getName(),company1.getName());
    }

}
