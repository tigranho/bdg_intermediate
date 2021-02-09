package com.bdg.airportSystem.DAO;

import com.bdg.airportSystem.model.Company;

import java.util.Set;

public interface CompanyDao {
    Company getById(int id);
    Set<Company> getAll();
    Set<Company> get (int page, int perPage, String sort);
    Company save (Company passenger);
    Company update (Company passenger);
    void delete (long companyId);
    void writeCompanyFromFileIntoDB();

}
