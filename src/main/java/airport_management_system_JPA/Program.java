package airport_management_system_JPA;

import airport_management_system_JPA.dao.impl.CompanyDAOImpl;
import airport_management_system_JPA.model.Company;

import java.util.Set;


public class Program {

    public static void main(String[] args) {

        CompanyDAOImpl companyDAO = new CompanyDAOImpl();

        // Test --getById-- method
//        System.out.println(companyDAO.getById(12));

        // Test --getAll-- method
//        for(Company company : companyDAO.getAll())
//        System.out.println(company);

        // Test --get-- method
        Set<Company> companies = companyDAO.get(2, 10,"ASC");
        for(Company company : companies)
            System.out.println(company);


    }
}
