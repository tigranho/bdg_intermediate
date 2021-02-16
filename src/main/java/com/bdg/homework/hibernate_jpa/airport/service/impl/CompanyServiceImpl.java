package com.bdg.homework.hibernate_jpa.airport.service.impl;

import com.bdg.homework.hibernate_jpa.airport.enums.impl.CompanyErrorCode;
import com.bdg.homework.hibernate_jpa.airport.excpetions.impl.CompanyException;
import com.bdg.homework.hibernate_jpa.airport.model.Company;
import com.bdg.homework.hibernate_jpa.airport.repository.CompanyDao;
import com.bdg.homework.hibernate_jpa.airport.repository.impl.CompanyDaoImpl;
import com.bdg.homework.hibernate_jpa.airport.service.CompanyService;
import com.bdg.homework.hibernate_jpa.airport.validator.CompanyValidate;

import java.util.Set;

public class CompanyServiceImpl implements CompanyService {


    private final CompanyDao companyDao;

    public CompanyServiceImpl() {
        companyDao = new CompanyDaoImpl();
    }


    @Override
    public Company getById(final int id) throws CompanyException {
        if (id <= 0) {
            throw new CompanyException(CompanyErrorCode.COMPANY_NOT_VALID_ID);
        }
        Company companyById = companyDao.getById(id);
        if (companyById == null) {
            throw new CompanyException(CompanyErrorCode.COMPANY_NOT_FOUND);
        }
        return companyById;
    }

    @Override
    public Set<Company> getAll() {
        Set<Company> companies = companyDao.getAll();
        return companies;
    }

    @Override
    public Set<Company> get(int page, int perPage, String sort) {
        return null;
    }

    @Override
    public Company save(final Company passenger) throws CompanyException {
        if (passenger == null || CompanyValidate.checkFields(passenger)) {
            throw new CompanyException(CompanyErrorCode.COMPANY_IS_EMPTY);
        }
        Company company = companyDao.save(passenger);
        if (company == null) {
            throw new CompanyException(CompanyErrorCode.COMPANY_SAVE);
        }
        return company;
    }

    @Override
    public Company update(final Company passenger) throws CompanyException {
        if (passenger == null || CompanyValidate.checkFields(passenger)) {
            throw new CompanyException(CompanyErrorCode.COMPANY_IS_EMPTY);
        }
        Company company = companyDao.update(passenger);
        if (company == null) {
            throw new CompanyException(CompanyErrorCode.COMPANY_SAVE);
        }
        return company;
    }

    @Override
    public void delete(final int companyId) throws CompanyException {
        if (companyId <= 0) {
            throw new CompanyException(CompanyErrorCode.COMPANY_IS_EMPTY);
        }
        Company company = companyDao.getById(companyId);
        if (company == null) {
            throw new CompanyException(CompanyErrorCode.COMPANY_NOT_FOUND);
        }
        companyDao.delete(companyId);

    }

}

