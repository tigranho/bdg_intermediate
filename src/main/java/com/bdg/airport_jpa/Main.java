package com.bdg.airport_jpa;

import com.bdg.airport_jpa.jpaDaoImpl.AddressDaoImpl;
import com.bdg.airport_jpa.jpaDaoImpl.PassengerDaoImpl;
import com.bdg.airport_jpa.model.Address;
import com.bdg.airport_jpa.model.Company;
import com.bdg.airport_jpa.model.Passenger;
import com.bdg.airport_jpa.util.ReadFromFile;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        AddressDaoImpl addressDao=new AddressDaoImpl();
        PassengerDaoImpl passengerDao=new PassengerDaoImpl();
       // addressDao.persist(new Address("Italy","Milan"));
//        Address address=addressDao.findById(2);
//        System.out.println(address.toString());
//         addressDao.delete(11);
//        addressDao.update(new Address("Russia","Moscow"),3);
//        List<Address>list=addressDao.findAll();
//        list.forEach(System.out::println);
//        Address address=new Address("Hungarya","Buxarest");
//        passengerDao.persist(new Passenger("Artur","094230081",address));
          ReadFromFile readFromFile=new ReadFromFile();
          readFromFile.addAddressToDb(ReadFromFile.readFile(ReadFromFile.PATH_PASSENGERS));
    }
}
