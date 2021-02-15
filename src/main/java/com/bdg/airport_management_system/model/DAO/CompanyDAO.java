package com.bdg.airport_management_system.model.DAO;

import com.bdg.airport_management_system.model.name.Company;

import java.util.Set;

public interface CompanyDAO {
    Company getById(int id);
    Set<Company> getAll();
    Set<Company> get(int page, int perPage, String sort);
    Company save(Company passenger);
    Company update(Company passenger);
    void delete(int companyId);
    void writeCompanyFromFileIntoDB();

}
