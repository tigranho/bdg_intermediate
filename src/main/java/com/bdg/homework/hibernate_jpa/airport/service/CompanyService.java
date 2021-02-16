package com.bdg.homework.hibernate_jpa.airport.service;

import com.bdg.homework.hibernate_jpa.airport.excpetions.impl.CompanyException;
import com.bdg.homework.hibernate_jpa.airport.model.Company;

import java.util.Set;

public interface CompanyService {

    Company getById(int id) throws CompanyException;
    Set<Company> getAll();
    Set<Company> get(int page, int perPage, String sort);
    Company save(Company passenger) throws CompanyException;
    Company update(Company passenger) throws CompanyException;
    void delete(int companyId) throws CompanyException;


}
