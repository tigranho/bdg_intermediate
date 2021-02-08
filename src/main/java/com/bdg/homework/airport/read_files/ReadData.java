package com.bdg.homework.airport.read_files;

import com.bdg.homework.airport.model.Address;
import com.bdg.homework.airport.model.Company;
import com.bdg.homework.airport.model.Passenger;
import com.bdg.homework.airport.repository.*;
import com.bdg.homework.airport.repository.impl.AddressDaoImpl;
import com.bdg.homework.airport.repository.impl.CompanyDaoImpl;
import com.bdg.homework.airport.repository.impl.PassengerDaoImpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReadData {


    public static List<String> readDataFromFileForPassenger() {
        File file = new File("D:\\book\\homework\\homework(JDBC)\\passengers.txt");
        List<String> passengers = new ArrayList<>();
        try {
            BufferedReader read = new BufferedReader(new FileReader(file));
            String passenger;
            while ((passenger = read.readLine()) != null) {
                passengers.add(passenger);
                passengers.removeIf((name) -> name.equals("name,phone,country,city"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return passengers;
    }


    public static void writePassengerDaraInDb(List<String> passengers) {
        PassengerDao passengerDao = new PassengerDaoImpl();
        AddressDao addressDao = new AddressDaoImpl();
        passengers.forEach((passenger) -> {
            String[] passengerData = passenger.split(",");
            Address address = new Address(passengerData[3], passengerData[2]);
            Passenger savePassenger = new Passenger(passengerData[0], passengerData[1], address);
            addressDao.save(address);
            passengerDao.save(savePassenger);

        });
    }


    public static List<String> readDataFromFileForCompany() {
        File file = new File("D:\\book\\homework\\homework(JDBC)\\companies.txt");
        List<String> companies = new ArrayList<>();
        try {
            BufferedReader read = new BufferedReader(new FileReader(file));
            String company;
            while ((company = read.readLine()) != null) {
                companies.add(company);
                companies.removeIf((name) -> name.equals("name,found_date"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return companies;
    }


    public static void writeCompanyDaraInDb(List<String> companies) {
        CompanyDao companyDao = new CompanyDaoImpl();
        companies.forEach((company) -> {
            String[] companyData = company.split(",");
            String[] foundDateData = companyData[1].split("/");
            LocalDate foundDate = LocalDate.of(Integer.parseInt(foundDateData[2]), Integer.parseInt(foundDateData[0]), Integer.parseInt(foundDateData[1]));
            Company saveCompany = new Company(companyData[0], foundDate);
            companyDao.save(saveCompany);
        });
    }
}
