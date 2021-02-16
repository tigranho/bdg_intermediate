package com.bdg.homework5.dao.impl;

import com.bdg.homework5.dao.AddressDAO;
import com.bdg.homework5.entity.Address;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AddressDAOImplTest {
    AddressDAO addressDAO;

    @Test
    public void getById(){
        addressDAO = new AddressDAOImpl();
        Address address = addressDAO.getById(1);
        Assert.assertEquals(1, (int) address.getId());
        Address address1 = addressDAO.getById(2);
        Assert.assertEquals(2, (int) address1.getId());
    }

    @Test
    public void save(){
        addressDAO = new AddressDAOImpl();
        Address address = new Address("Armenia","Yerevan");
        Address address1 = addressDAO.save(address);
        List<Address> addressList = addressDAO.getAll();
        Assert.assertEquals(addressList.get(addressList.size() - 1).getId(), address1.getId());
    }

    @Test
    public void delete(){
        addressDAO = new AddressDAOImpl();
        List<Address> addressList = addressDAO.getAll();
        addressDAO.delete(6);
        addressDAO.delete(7);
        List<Address> addressList1 = addressDAO.getAll();
        Assert.assertEquals(2, addressList.size() - addressList1.size());
    }
}
