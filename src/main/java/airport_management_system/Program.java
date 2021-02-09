package airport_management_system;

import airport_management_system.dao.impl.CompanyDAOImpl;
import airport_management_system.dao.impl.TripDAOImpl;
import airport_management_system.model.Company;
import airport_management_system.model.Trip;
import airport_management_system.services.PgSql;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.HashSet;
import java.util.Set;

public class Program {
    public static void main(String[] args) throws SQLException {
        PgSql.initDatabase();

        //***********************************************
        // TEST companyDAOImpl
        //***********************************************

        // Test --getById-- method
        CompanyDAOImpl companyDAO = new CompanyDAOImpl();
//        Company company = companyDAO.getById(10);
//        System.out.println(company);


        // Test --save-- method
//        Company newCompany = new Company("Armenia", LocalDate.of(1983, 10, 10));
//        System.out.println(companyDAO.save(newCompany));

        // Test --get-- method
//        System.out.println(companyDAO.get(5, 10, "DESC"));


        // Test --delete-- method
//        companyDAO.delete(1018);


        //***********************************************
        // TEST tripDAOImpl
        //***********************************************
        TripDAOImpl tripDAO = new TripDAOImpl();

        // Test --getById-- method
//        System.out.println(tripDAO.getById(1));


        // Test --getAll-- method
        Set<Trip> trips = tripDAO.getAll();
        for (Trip trip : trips) {
            System.out.println(trip);
        }


        // Test --get-- method
//        Set<Trip> trips = tripDAO.get(0, 5, "DESC");
//        for(Trip trip : trips) {
//            System.out.println(trip);
//        }


        // Test --save-- method
//        Trip newTrip = new Trip(
//                LocalDateTime.of(2021, 5, 21, 10, 00),
//                LocalDateTime.of(2021, 5, 21, 15, 00),
//                "Yerevan", "Los Angeles", new Company("Armenia", LocalDate.of(1983, 10, 10)));
//        System.out.println(tripDAO.save(newTrip));


        // Test --saveAll-- method
//        Set<Trip> tripSet = new HashSet<>();
//        tripSet.add(new Trip(
//                LocalDateTime.of(2021, 5, 30, 9, 10),
//                LocalDateTime.of(2021, 5, 30, 13, 00),
//                "Tokyo", "Moscow", new Company("Tambee", LocalDate.of(1973, 5, 7))));
//
//        tripSet.add(new Trip(
//                LocalDateTime.of(2021, 6, 10, 12, 40),
//                LocalDateTime.of(2021, 6, 10, 13, 35),
//                "Washington", "Ontario", new Company("Skyvu", LocalDate.of(2010, 01, 26))));
//
//        System.out.println(tripDAO.saveAll(tripSet));

        // Test --getTripsFrom- and -getTripsTo-- methods
        System.out.println();
        System.out.println(tripDAO.getTripsFrom("Ontario"));
        System.out.println(tripDAO.getTripsTo("Yerevan"));
    }
}