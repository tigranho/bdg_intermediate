package com.bdg.airport.dao;

import com.bdg.airport.model.Company;

import java.util.Set;

public interface DaoCompany {


    void create();

    void saveCompanyFromFile();

    void save(Company company);

    void update(Company company);

    void delete(long companyId);

    Set<Company> getAll();

    Set<Company> get(int page, int perPage, String sort);

}
