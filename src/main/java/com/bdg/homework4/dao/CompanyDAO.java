package com.bdg.homework4.dao;

import com.bdg.homework4.entity.Company;
import com.bdg.homework4.exception.NotFoundException;

import java.sql.SQLException;
import java.util.Set;

public interface CompanyDAO {
    Company getById(int id) throws SQLException, NotFoundException;
    Set<Company> getAll() throws SQLException;
    Set<Company> get(int page, int perPage, String sort);
    Company save(Company company)throws SQLException;
    Company update(Company company)throws SQLException;
    void delete(int companyId)throws SQLException;

}
