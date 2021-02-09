package com.bdg.homework4.service;

import com.bdg.homework4.dao.CompanyDAO;
import com.bdg.homework4.entity.Company;
import com.bdg.homework4.service.exception.NotFoundException;
import com.bdg.homework4.utils.connect.ConnectToDb;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CompanyDAOImpl extends ConnectToDb implements CompanyDAO {

    Connection connection = getConnection();

    public CompanyDAOImpl() {
    }

    @Override
    public Company getById(int id) throws SQLException, NotFoundException {
        PreparedStatement preparedStatement = null;
        String sql = "select * from company where id = ?";
        Company company = new Company();
        try {
            preparedStatement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.first() || id <= 0) {
                throw new NotFoundException("incorrect id");
            } else {
                company.setId(resultSet.getInt(1));
                company.setName(resultSet.getString("name"));
                company.setDate(resultSet.getDate("found_date"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return company;
    }

    @Override
    public Set<Company> getAll() throws SQLException {
        Set<Company> companySet = new HashSet<>();
        String sql = "select name, found_date from company";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Company company = new Company();
                company.setName(rs.getString("name"));
                company.setDate(rs.getDate("found_date"));
                companySet.add(company);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return companySet;
    }

    @Override
    public Set<Company> get(int page, int perPage, String sort) {
        PreparedStatement preparedStatement = null;
        Set<Company> companySet = new HashSet<>();
        String sql = "select * from company order by ? limit ? offset ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, sort);
            preparedStatement.setInt(2, page);
            preparedStatement.setInt(3, perPage);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Company company = new Company();
                company.setId(rs.getInt(1));
                company.setName(rs.getString(2));
                company.setDate(rs.getDate(3));
                companySet.add(company);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return companySet;
    }

    @Override
    public Company save(Company company) throws SQLException {
        PreparedStatement preparedStatement = null;
        Company company1 = new Company();
        String sql = "insert into company (name, found_date) values(?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            preparedStatement.setString(1, company.getName());
            preparedStatement.setDate(2, company.getDate());
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.executeQuery("select * from company");
            rs.last();

            company1.setName(rs.getString("name"));
            company1.setDate(rs.getDate("found_date"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return company1;
    }

    @Override
    public Company update(Company company) throws SQLException, NotFoundException {
        PreparedStatement preparedStatement = null;
        Company company1 = new Company();
        String sql = "update  company set name = ?, found_date = ? where id = ?";
        try {
            preparedStatement = connection.prepareStatement("select * from company where id = ?",
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            preparedStatement.setInt(1, company.getId());
            ResultSet rs = preparedStatement.executeQuery();

            if (!rs.first() || company.getId() <= 0) {
                throw new NotFoundException("not found date by that ID");
            } else {
                preparedStatement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
                preparedStatement.setString(1, company.getName());
                preparedStatement.setDate(2, company.getDate());
                preparedStatement.setInt(3, company.getId());
                preparedStatement.executeUpdate();
                preparedStatement = connection.prepareStatement("select * from company where id = ?");
                preparedStatement.setInt(1, company.getId());
                rs = preparedStatement.executeQuery();
                rs.next();
                company1.setName(rs.getString("name"));
                company1.setDate(rs.getDate("found_date"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return company1;
    }

    @Override
    public void delete(int companyId) throws SQLException {
        String sql = "delete from company where id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, companyId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
}
