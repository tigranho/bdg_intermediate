package com.bdg.airport_management_system.model.DAO;

import com.bdg.airport_management_system.model.name.Company;
import com.bdg.airport_management_system.model.configure.DBconnection;
import com.bdg.airport_management_system.model.util.ReadFromFile;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import static com.bdg.airport_management_system.model.util.ReadFromFile.fromFileToList;

public class CompanyDAOImpl implements CompanyDAO {

    private final static String GET_COMPANY_BY_ID = "select * from company where id=?";
    private final static String GET_ALL_COMPANIES = "select * from company";
    private final static String SAVE_COMPANY = "insert  into company(name,found_date) values (?,?)";
    private final static String UPDATE_COMPANY = "update company set name=?,found_date=?  where id=?";
    private final static String DELETE_COMPANY = "delete from company where  id=?";
    private final Connection connection = DBconnection.getConnection();

    @Override
    public Company getById(int id) {
        Company company = null;
        try {
            PreparedStatement statement = connection.prepareStatement(GET_COMPANY_BY_ID);
            statement.setInt(1, (int) id);
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
        Company company;
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
            statement.setTimestamp(2, Timestamp.valueOf(passenger.getFoundingDate().atStartOfDay()));
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
            statement.setTimestamp(2, Timestamp.valueOf(passenger.getFoundingDate().atStartOfDay()));
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
            statement.setInt(1, companyId);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

@Override
public void writeCompanyFromFileIntoDB() {
        Company company = new Company();
        List<String> companies = fromFileToList(ReadFromFile.COMPANIES_PATH);

        try {
            for (String s : companies) {
                String[] companiesArray = s.split(",");
                String[] dates = companiesArray[1].split("/");
                LocalDate foundingDate = LocalDate.of(Integer.parseInt(dates[2]),
                        Integer.parseInt(dates[0]),
                        Integer.parseInt(dates[1]));

                company.setName(companiesArray[0]);
                company.setFoundingDate(foundingDate);

                PreparedStatement preparedStatement = connection.prepareStatement(SAVE_COMPANY);
                preparedStatement.setString(1, company.getName());
                preparedStatement.setObject(2, company.getFoundingDate());
                preparedStatement.executeUpdate();

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}