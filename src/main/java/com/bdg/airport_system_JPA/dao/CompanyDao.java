package com.bdg.airport_system_JPA.dao;

import com.bdg.airport_system_JPA.model.Company;

import java.util.Set;

public interface CompanyDao {

    Company getById(long id);
    Set<Company> getAll();
    Set<Company> get (int page, int perPage, String sort);
    Company save (Company company);
    Company update (Company company, long companyId);
    void delete (long companyId);
    void writeCompanyFromFileIntoDB();

}
