package airport_management_system.dao.impl;

import airport_management_system.dao.CompanyDAO;
import airport_management_system.model.Company;
import airport_management_system.model.Trip;
import airport_management_system.services.PgSql;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class CompanyDAOImpl implements CompanyDAO {

    private void getData(Company company, ResultSet resultSet) throws SQLException {
        company.setId(resultSet.getLong("id"));
        company.setName(resultSet.getString("name"));
        company.setFound_date(resultSet.getDate("found_date").toLocalDate());
    }

    @Override
    public Company getById(long id) {
        Company company = new Company();
        String sql = "SELECT * FROM company WHERE id=?";
        try (Connection cn = DriverManager.getConnection(PgSql.url, PgSql.username, PgSql.password);
             PreparedStatement stm = cn.prepareStatement(sql)) {
            stm.setLong(1, id);
            ResultSet resultSet = stm.executeQuery();

            if (resultSet.next()) {

                getData(company, resultSet);
            }

        } catch (Exception exception) {
            System.out.println(exception);
        }
        return company;
    }

    @Override
    public Set<Company> getAll() {
        Set<Company> companies = new HashSet<>();
        String sql = "SELECT * FROM company";
        try (Connection cn = DriverManager.getConnection(PgSql.url, PgSql.username, PgSql.password);
             PreparedStatement stm = cn.prepareStatement(sql)) {
            ResultSet resultSet = stm.executeQuery();

            while (resultSet.next()) {
                Company company = new Company();

                getData(company, resultSet);

                companies.add(company);
            }

        } catch (Exception exception) {
            System.out.println(exception);
        }
        return companies;
    }

    @Override
    public Set<Company> get(int page, int perPage, String sort) {
        Set<Company> companies = new HashSet<>();
        String sql = "SELECT * FROM company ORDER BY name " + sort + " LIMIT ? OFFSET ?";
        try (Connection cn = DriverManager.getConnection(PgSql.url, PgSql.username, PgSql.password);
             PreparedStatement stm = cn.prepareStatement(sql)) {

            stm.setInt(1, perPage);
            stm.setInt(2, page);

            ResultSet resultSet = stm.executeQuery();

            while (resultSet.next()) {
                Company company = new Company();

                getData(company, resultSet);

                companies.add(company);
            }

        } catch (Exception exception) {
            System.out.println(exception);
        }
        return companies;
    }


    private Company getCompany(Company company, String sql) {
        try (Connection cn = DriverManager.getConnection(PgSql.url, PgSql.username, PgSql.password);
             PreparedStatement stm2 = cn.prepareStatement(sql)) {

            stm2.setString(1, company.getName());
            stm2.setDate(2, Date.valueOf(company.getFound_date()));
            stm2.executeUpdate();
        } catch (Exception exception) {
            System.out.println(exception);
        }
        return company;
    }

    @Override
    public Company save(Company company) {

        String sql = "INSERT INTO company (name, found_date) VALUES (?, ?)";
        return getCompany(company, sql);
    }

    @Override
    public Company update(long companyId, Company company) {
        String sql = "UPDATE company name=?, found_date=? WHERE id=" + companyId;
        return getCompany(company, sql);
    }


    @Override
    public void delete(long companyId) {
        String sql = "DELETE FROM company WHERE id=" + companyId;
        try (Connection cn = DriverManager.getConnection(PgSql.url, PgSql.username, PgSql.password);
             PreparedStatement stm = cn.prepareStatement(sql)) {
            stm.executeUpdate();
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }

    public void deleteRange(long fromId, long toId) {
        String sql = "DELETE FROM company WHERE id >= ? AND id <= ?";
        try (Connection cn = DriverManager.getConnection(PgSql.url, PgSql.username, PgSql.password);
             PreparedStatement stm = cn.prepareStatement(sql)) {

            stm.setLong(1, fromId);
            stm.setLong(2, toId);
            stm.executeUpdate();

        } catch (Exception exception) {
            System.out.println(exception);
        }
    }
}
