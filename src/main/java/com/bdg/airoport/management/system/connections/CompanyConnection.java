package com.bdg.airoport.management.system.connections;

import com.bdg.airoport.management.system.model.Company;
import com.bdg.airoport.management.system.dao.CompanyDao;
import com.bdg.airoport.management.system.dao.impl.CompanyDaoImpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CompanyConnection {
    public static List<String> readDataFromFileForCompany() {
        File file = new File("D:\\homework\\homework(JDBC)\\companies.txt");
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

    public static void main(String[] args) {
        writeCompanyDaraInDb(readDataFromFileForCompany());
    }
}
