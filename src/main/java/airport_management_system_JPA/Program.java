package airport_management_system_JPA;

import airport_management_system_JPA.dao.impl.CompanyDAOImpl;
import airport_management_system_JPA.dao.impl.TripDAOImpl;
import airport_management_system_JPA.model.Company;
import airport_management_system_JPA.model.Trip;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class Program {

    public static void main(String[] args) {

        //***********************************************
        // TEST CompanyDAOImpl
        //***********************************************

        CompanyDAOImpl companyDAO = new CompanyDAOImpl();


        // Test --getById-- method
//        System.out.println(companyDAO.getById(12));

        // Test --getAll-- method
//        for(Company company : companyDAO.getAll())
//        System.out.println(company);

        // Test --get-- method
//        List<Company> companies = companyDAO.get(5, 10,"ASC");
//        for(Company company : companies)
//            System.out.println(company);

        // Test --save-- method
//        Company company = new Company("Pobeda", LocalDate.of(2005, 2 , 1));
//        System.out.println(companyDAO.save(company));

        // Test --update-- method
//        Company company = new Company("American Airlines", LocalDate.of(2005, 2 , 1));
//        System.out.println(companyDAO.update(1, company));

        // Test --delete-- method
//        companyDAO.delete(4);


        //***********************************************
        // TEST TripDAOImpl
        //***********************************************

        TripDAOImpl tripDAO = new TripDAOImpl();

        // Test --getById-- method
//        System.out.println(tripDAO.getById(1));

        // Test --getAll-- method
//        for(Trip trip : tripDAO.getAll())
//        System.out.println(trip);

        // Test --get-- method
        List<Trip> trips = tripDAO.get(1,2,"DESC");
        for(Trip trip : trips)
            System.out.println(trip);
    }
}
