package com.bdg.homework.airport.repository.impl;

import com.bdg.homework.airport.configuration.DbConnection;
import com.bdg.homework.airport.model.Company;
import com.bdg.homework.airport.repository.CompanyDao;

import java.sql.*;
import java.util.Set;
import java.util.TreeSet;

public class CompanyDaoImpl implements CompanyDao {

    private Connection connection= DbConnection.getInstance().getConnection();
    private final static String GET_COMPANY_BY_ID = "select * from company where id=?";
    private final static String GET_ALL_COMPANIES = "select * from company";
    private final static String SAVE_COMPANY = "insert  into company(name,found_date) values (?,?)";
    private final static String UPDATE_COMPANY = "update company set name=?,found_date=?  where id=?";
    private final static String DELETE_COMPANY = "delete from company where  id=?";


    @Override
    public Company getById(int id) {
        Company company = null;
        try {
            PreparedStatement statement = connection.prepareStatement(GET_COMPANY_BY_ID);
            statement.setInt(1, id);
            ResultSet res = statement.executeQuery();
            if (res.next()) {
                company = new Company();
                company.setId(res.getInt(1));
                company.setName(res.getString(2));
                company.setFoundingDate(res.getTimestamp(3).toLocalDateTime().toLocalDate());
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return company;
    }

    @Override
    public Set<Company> getAll() {
        Company company = null;
        Set<Company> companies = new TreeSet<>();
        try {
            PreparedStatement statement = connection.prepareStatement(GET_ALL_COMPANIES);
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                company = new Company();
                company.setId(set.getInt(1));
                company.setName(set.getString(2));
                company.setFoundingDate(set.getTimestamp(3).toLocalDateTime().toLocalDate());
                companies.add(company);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return companies;
    }

    @Override
    public Set<Company> get(int page, int perPage, String sort) {
        return null;
    }

    @Override
    public Company save(Company passenger) {
       try {
            PreparedStatement statement = connection.prepareStatement(SAVE_COMPANY, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, passenger.getName());
            statement.setTimestamp(2,Timestamp.valueOf(passenger.getFoundingDate().atStartOfDay()));
            statement.executeUpdate();
            try (ResultSet genId = statement.getGeneratedKeys()) {
                if (genId.next()) {
                    passenger.setId(genId.getInt(1));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return passenger;
    }

    @Override
    public Company update(Company passenger) {
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE_COMPANY, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, passenger.getName());
            statement.setTimestamp(2,Timestamp.valueOf(passenger.getFoundingDate().atStartOfDay()));
            statement.setInt(3, passenger.getId());
            statement.executeUpdate();
            try (ResultSet genId = statement.getGeneratedKeys()) {
                if (genId.next()) {
                    passenger.setId(genId.getInt(1));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return passenger;
    }

    @Override
    public void delete(int companyId) {
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE_COMPANY, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1,companyId);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
