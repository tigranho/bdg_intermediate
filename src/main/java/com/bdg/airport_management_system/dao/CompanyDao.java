package com.bdg.airport_management_system.dao;

import com.bdg.airport_management_system.model.Company;

import java.util.Set;

public interface CompanyDao {
    Company getById(int id);
    Set<Company> getAll();
    Set<Company> get(int page, int perPage, String sort);
    Company save(Company passenger);
    Company update(Company passenger);
    void delete(long companyId);

}
