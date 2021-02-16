package com.bdg.homework.hibernate_jpa.airport.repository;

import com.bdg.homework.hibernate_jpa.airport.model.Company;

import java.util.Set;

public interface CompanyDao {
    Company getById(int id);
    Set<Company> getAll();
    Set<Company> get(int page, int perPage, String sort);
    Company save(Company passenger);
    Company update(Company passenger);
    void delete(int companyId);

}
