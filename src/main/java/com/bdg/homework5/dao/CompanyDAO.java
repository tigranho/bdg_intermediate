package com.bdg.homework5.dao;

import com.bdg.homework5.entity.Company;
import com.bdg.homework4.exception.NotFoundException;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public interface CompanyDAO {
    Company getById(int id) ;
    List<Company> getAll() ;
    List<Company> get(int page, int perPage);
    Company save(Company company);
    void delete(int companyId);
}
