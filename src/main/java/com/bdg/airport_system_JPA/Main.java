package com.bdg.airport_system_JPA;

import com.bdg.airport_system_JPA.dao.AddressDao;
import com.bdg.airport_system_JPA.dao.CompanyDao;
import com.bdg.airport_system_JPA.dao.PassengerDao;
import com.bdg.airport_system_JPA.dao.dao_impl.AddressDaoImpl;
import com.bdg.airport_system_JPA.dao.dao_impl.CompanyDaoImpl;
import com.bdg.airport_system_JPA.dao.dao_impl.PassengerDaoImpl;

public class Main {

    public static void main(String[] args) {


        AddressDao address = new AddressDaoImpl();
        address.writeAddressFromFileIntoDB();

//        CompanyDao company = new CompanyDaoImpl();
//        company.writeCompanyFromFileIntoDB();
//
//        PassengerDao passenger = new PassengerDaoImpl();
//        passenger.writePassengersFromFileToDB();
    }
}
