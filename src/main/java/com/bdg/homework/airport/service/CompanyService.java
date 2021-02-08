package com.bdg.homework.airport.service;

import com.bdg.homework.airport.model.Company;

import java.util.Set;

public interface CompanyService {

    Company getById(int id);
    Set<Company> getAll();
    Set<Company> get(int page, int perPage, String sort);
    Company save(Company passenger);
    Company update(Company passenger);
    void delete(int companyId);


}
