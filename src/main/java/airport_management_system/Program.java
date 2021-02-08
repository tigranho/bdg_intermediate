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
import java.util.Set;

public class Program {
    public static void main(String[] args) throws SQLException {
        PgSql.initDatabase();

        // TEST CompanyDAOImpl
        CompanyDAOImpl companyDAO = new CompanyDAOImpl();
//        Company company = companyDAO.getById(10);
//        System.out.println(company);

        /*
         * INSERT ELEMENT INTO company TABLE
         */

//        Company newCompany = new Company("Armenia", LocalDate.of(1983, 10, 10));
//        System.out.println(companyDAO.save(newCompany));

        /*
         * GET ELEMENT FROM company WITH GIVEN LIMITS AND OFFSET
         * AND ORDERED BY name DESC
         */
//        System.out.println(companyDAO.get(5, 10, "DESC"));

        companyDAO.delete(1018);


        //***********************************************
        // TEST tripDAOImpl
        //***********************************************
        TripDAOImpl tripDAO = new TripDAOImpl();

        // Test --getById-- method
//        System.out.println(tripDAO.getById(1));


        // Test --getAll-- method
//        System.out.println(tripDAO.getAll());


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


    }
}
