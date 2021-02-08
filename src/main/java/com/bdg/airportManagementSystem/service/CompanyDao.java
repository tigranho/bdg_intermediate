package com.bdg.airportManagementSystem.service;

import com.bdg.airportManagementSystem.model.Company;

import java.util.Set;

public interface CompanyDao {
    Company getById(long id);
    Set<Company> getAll();
    Set<Company> get(int page, int perPage, String sort);
    Company save(Company passenger);
    Company update(Company passenger);
    void delete(long companyId);

}
