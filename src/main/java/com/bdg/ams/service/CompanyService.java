package com.bdg.ams.service;

import com.bdg.ams.exception.DatabaseException;
import com.bdg.ams.model.Company;
import com.bdg.ams.repo.dao.CompanyDao;

import java.util.Optional;

public class CompanyService {

    final CompanyDao companyDao;

    public CompanyService() {
        this.companyDao = new com.bdg.ams.repo.dao.daoimpl.CompanyDaoImpl();
    }

    public void companyById(long id) {
        try {
            Optional<Company> byId = companyDao.getById(id);
            if (byId.isPresent()) {
                System.out.println(byId.get());

            } else {
                System.out.println("Company not found");

            }
        } catch (DatabaseException e) {
            e.printStackTrace();
        }
    }
    public void  allCompany(){
        companyDao.getAll().forEach(System.out::println);
    }

    public Company save(Company company) {
        return companyDao.save(company);
    }

    public Company update(Company company) {

        return companyDao.update(company);
    }

    public void delete(int companyId) {

        companyDao.delete(companyId);
    }
}
