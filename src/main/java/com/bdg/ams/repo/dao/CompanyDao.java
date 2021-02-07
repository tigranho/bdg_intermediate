package com.bdg.ams.repo.dao;

import com.bdg.ams.exception.DatabaseException;
import com.bdg.ams.model.Company;

import java.util.Optional;
import java.util.Set;

public interface CompanyDao {

    Optional<Company> getById(long id) throws DatabaseException;

    Set<Company> getAll();

    Set<Company> get(int page, int perPage, String sort);

    Company save(Company company);

    Company update(Company company);

    void delete(long companyId);

}
