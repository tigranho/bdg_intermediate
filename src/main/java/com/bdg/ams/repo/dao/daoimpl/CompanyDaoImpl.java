package com.bdg.ams.repo.dao.daoimpl;

import com.bdg.ams.exception.DatabaseException;
import com.bdg.ams.model.Company;
import com.bdg.ams.repo.dao.CompanyDao;
import com.bdg.ams.util.Convert;
import com.bdg.ams.util.DatabaseConnectionFactory;

import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class CompanyDaoImpl implements CompanyDao {
    @Override
    public Optional<Company> getById(long id) throws DatabaseException {


        try (Connection connection = DatabaseConnectionFactory.
                getInstance().openConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(AsmConst.GET_COMPANY_BY_ID)) {

            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return Optional.of(CompanyDaoImpl.toCompany(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Set<Company> getAll() {

        Set<Company> companies = new LinkedHashSet<>();
        try (Connection connection = DatabaseConnectionFactory.getInstance().openConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(AsmConst.GET_ALL_COMPANIES)) {
            while (resultSet.next()) {
                companies.add(toCompany(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return companies;
    }


    @Override
    public Set<Company> get(int page, int perPage, String sort) {
        return null;
    }

    @Override
    public Company save(Company company) {

        try (Connection connection = DatabaseConnectionFactory.
                getInstance().openConnection();
             PreparedStatement preparedStatement = connection.
                     prepareStatement(AsmConst.SAVE_COMPANY, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, company.getName());
            preparedStatement.setDate(2, java.sql.Date.valueOf(company.getFoundingDate()));
            preparedStatement.executeUpdate();
            try (ResultSet genId = preparedStatement.getGeneratedKeys()) {
                if (genId.next()) {
                    company.setId(genId.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return company;

    }

    @Override
    public Company update(Company company) {

        try (Connection connection = DatabaseConnectionFactory.
                getInstance().openConnection();
             PreparedStatement preparedStatement = connection.
                     prepareStatement(AsmConst.UPDATE_COMPANY, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, company.getName());
            preparedStatement.setDate(2, java.sql.Date.valueOf(company.getFoundingDate()));
            preparedStatement.setInt(3, company.getId());
            preparedStatement.executeUpdate();
            try (ResultSet genId = preparedStatement.getGeneratedKeys()) {
                if (genId.next()) {
                    company.setId(genId.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return company;
    }

    @Override
    public void delete(long companyId) {
        try (Connection connection = DatabaseConnectionFactory.
                getInstance().openConnection();
             PreparedStatement preparedStatement = connection.
                     prepareStatement(AsmConst.DELETE_COMPANY, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setLong(1, companyId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static Company toCompany(ResultSet resultSet) throws SQLException {
        Company company = new Company();
        company.setId(resultSet.getInt("id"));
        company.setName(resultSet.getString("name"));
        Date founding_data = resultSet.getDate("found_date");
        company.setFoundingDate(Convert.convertToLocalDateViaInstant(founding_data));
        return company;
    }


}
