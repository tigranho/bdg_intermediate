package com.bdg.ams.service;

import com.bdg.ams.model.Address;
import com.bdg.ams.model.Company;
import com.bdg.ams.model.Passenger;
import com.bdg.ams.repo.dao.AddressDao;
import com.bdg.ams.repo.dao.CompanyDao;
import com.bdg.ams.repo.dao.PassengerDao;
import com.bdg.ams.repo.dao.daoimpl.AddressDaoImpl;
import com.bdg.ams.repo.dao.daoimpl.CompanyDaoImpl;
import com.bdg.ams.repo.dao.daoimpl.PassengerDaoImpl;
import com.bdg.ams.util.Convert;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZonedDateTime;

public class FillDataService {
    static final String PATH_COMPANY = "src/main/resources/ams/companies.txt";
    static final String PATH_PASSENGER = "src/main/resources/ams/passengers.txt";
    CompanyDao companyDao;
    PassengerDao passengerDao;
    AddressDao addressDao;

    BufferedReader bufferedReader = null;

    public FillDataService() {
        this.companyDao = new CompanyDaoImpl();
        this.passengerDao = new PassengerDaoImpl();
        this.addressDao = new AddressDaoImpl();
    }

    public void fillCompanyData() {

        try {
            bufferedReader = new BufferedReader(new FileReader(PATH_COMPANY));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String lineOfTxt;
        try {
            lineOfTxt = bufferedReader.readLine();
            while ((lineOfTxt = bufferedReader.readLine()) != null) {
                String[] lineValue = lineOfTxt.split(",");
                Company company = getCompany(lineValue);
                companyDao.save(company);


            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    private Company getCompany(String[] lineValue) {
        Company company = new Company();
        company.setName(lineValue[0]);
        LocalDate dateTime = null;
        try {
            dateTime = getLocalDate(lineValue[1]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        company.setFoundingDate(dateTime);
        return company;
    }

    private LocalDate getLocalDate(String charSequence) throws ParseException {
        ZonedDateTime zdt = Convert.getZonedDateTime(charSequence);
        LocalDate localDate = zdt.toLocalDate();
        return localDate;
    }

    public void fillPassengerData() {
        try {
            bufferedReader = new BufferedReader(new FileReader(PATH_PASSENGER));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String lineOfTxt;
        try {
            lineOfTxt = bufferedReader.readLine();
            while ((lineOfTxt = bufferedReader.readLine()) != null) {
                String[] lineValue = lineOfTxt.split(",");
                Passenger passenger = getPassenger(lineValue);
                passengerDao.save(passenger);


            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private Passenger getPassenger(String[] lineValue) {

        Passenger passenger = new Passenger();
        passenger.setName(lineValue[0]);
        passenger.setPhone(lineValue[1]);
        passenger.setAddress(getAddress(lineValue[2], lineValue[3]));

        return passenger;
    }

    private Address getAddress(String country, String city) {

        Address address = new Address();
        address.setCountry(country);
        address.setCity(city);
        Address save = addressDao.save(address);


        return save;
    }


}

