package com.bdg.homework.jdbc.airport.service;

import com.bdg.homework.jdbc.airport.excpetions.impl.CompanyException;
import com.bdg.homework.jdbc.airport.model.Company;

import java.util.Set;

public interface CompanyService {

    Company getById(int id) throws CompanyException;
    Set<Company> getAll();
    Set<Company> get(int page, int perPage, String sort);
    Company save(Company passenger) throws CompanyException;
    Company update(Company passenger) throws CompanyException;
    void delete(int companyId) throws CompanyException;


}
