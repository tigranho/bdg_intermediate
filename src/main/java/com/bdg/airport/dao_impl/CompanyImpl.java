package com.bdg.airport.dao_impl;

import com.bdg.airport.dao.DaoCompany;
import com.bdg.airport.jdbc.JDBC;
import com.bdg.airport.model.Company;
import com.bdg.airport.util.ReadDataFromFile;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.*;

import static com.bdg.airport.util.ReadDataFromFile.readFile;

public class CompanyImpl implements DaoCompany {
    private final static String DELETE_QUERY = "DELETE FROM company WHERE  id=?";
    private final static String UPDATE_QUERY = "UPDATE airport.companies SET name = ?, found_date = ?WHERE id =?";
    private final static String SAVE_QUERY = "INSERT INTO airport.companies (name, found_date)" + " values (?, ?)";
    private final static String SAVE_ALL_FROM_FILE_QUERY = " INSERT INTO airport.companies (name, found_date)" + " values (?, ?)";
    private final static String CREATE_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS airport.companies (" + "id INT AUTO_INCREMENT NOT NULL," + "name VARCHAR(45) NOT NULL," + "found_date DATE NOT NULL," + "PRIMARY KEY (id))";
    private final static String GET_ALL_COMPANY="SELECT * FROM airport.companies";

    Connection conn;
    List<String> list;
    PreparedStatement preparedStatement = null;
    Company companies = new Company();

    {
        try {
            conn = DriverManager.getConnection(JDBC.JdbcInit.DB_URL, JDBC.JdbcInit.USER, JDBC.JdbcInit.PASS);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    @Override
    public void create() {
        try {
            System.out.println("Creating table companies in given database...");
            PreparedStatement preparedStatement = conn.prepareStatement(CREATE_TABLE_QUERY);
            preparedStatement.executeUpdate();
            System.out.println("Created table companies in given database...");
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void saveCompanyFromFile() {
        try {
            list = new ArrayList<>();
            list = (readFile(ReadDataFromFile.PATH_COMPANIES));
            for (int j = 1; j < list.size(); j++) {
                String[] strings = list.get(j).split(",");
                companies.setName(strings[0]);
                DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder();
                builder.parseCaseInsensitive();
                builder.parseLenient();
                builder.appendPattern("[M/dd/yyyy]");
                builder.appendPattern("[M/d/yyyy]");
                builder.appendPattern("[MM/dd/yyyy]");
                DateTimeFormatter formatter2 = builder.toFormatter(Locale.ENGLISH);
                LocalDate localDate = LocalDate.parse(strings[1], formatter2);
                companies.setFound_date(localDate);
                companies.setName(strings[0]);
                preparedStatement = conn.prepareStatement(SAVE_ALL_FROM_FILE_QUERY);
                preparedStatement.setString(1, companies.getName());
                preparedStatement.setObject(2, companies.getFound_date());
                preparedStatement.executeUpdate();
            }

            conn.close();
        } catch (Throwable sqlException) {
            sqlException.printStackTrace();

        }

    }

    @Override
    public void save(Company companies) {
        try {
            preparedStatement = conn.prepareStatement(SAVE_QUERY);
            preparedStatement.setString(1, companies.getName());
            preparedStatement.setObject(2, companies.getFound_date());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Company companies) {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_QUERY);
            preparedStatement.setString(1, companies.getName());
            preparedStatement.setObject(2, companies.getFound_date());
            preparedStatement.setInt(3, companies.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void delete(long companyId) {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(DELETE_QUERY);
            preparedStatement.setLong(1, companyId);
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public Set<Company> getAll() {
        Company company = null;
        Set<Company> companies = new TreeSet<>();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(GET_ALL_COMPANY);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                company = new Company();
                company.setId(resultSet.getInt(1));
                company.setName(resultSet.getString(2));
                company.setFound_date(resultSet.getDate(3).toLocalDate());
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

}
