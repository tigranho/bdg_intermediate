package com.bdg.airportSystem.DAO;

import com.bdg.airportSystem.config.ConnectionFactory;
import com.bdg.airportSystem.model.Company;
import com.bdg.airportSystem.util.ReadFile;

import java.sql.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.bdg.airportSystem.util.ReadFile.fromFileToList;


public class CompanyDaoImpl implements CompanyDao{

    private final static String GET_COMPANY_BY_ID = "select * from company where id=?";
    private final static String GET_ALL_COMPANIES = "select * from company";
    private final static String SAVE_COMPANY = "insert  into company(name,found_date) values (?,?)";
    private final static String UPDATE_COMPANY = "update company set name=?,found_date=?  where id=?";
    private final static String DELETE_COMPANY = "delete from company where  id=?";
    private final Connection connection = ConnectionFactory.getConnection();



    @Override
    public Company getById(int id) {
        Company company = null;

        try {
            PreparedStatement statement = connection.prepareStatement(GET_COMPANY_BY_ID);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()){
                company = new Company();
                company.setId(rs.getInt(1));
                company.setName(rs.getString(2));
                company.setFoundingDate(rs.getTimestamp(3).toLocalDateTime().toLocalDate());
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return company;
    }

    @Override
    public Set<Company> getAll() {
        Company company;
        Set<Company> companies = new HashSet<>();
        try {
            PreparedStatement statement = connection.prepareStatement(GET_ALL_COMPANIES);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                company = new Company();
                company.setId(rs.getInt(1));
                company.setName(rs.getString(2));
                company.setFoundingDate(rs.getTimestamp(3).toLocalDateTime().toLocalDate());
                companies.add(company);
            }
        }catch (SQLException e){
            e.printStackTrace();
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
            try (ResultSet generateId = statement.getGeneratedKeys()){
                if (generateId.next()){
                    passenger.setId(generateId.getInt(1));
                }
            }

            }catch (SQLException e){
            e.printStackTrace();

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
           try (ResultSet generateId = statement.getGeneratedKeys()) {
               if (generateId.next()) {
                   passenger.setId(generateId.getInt(1));
               }
           }
       } catch (SQLException e) {
           e.printStackTrace();
       }

        return passenger;
    }


    @Override
    public void delete(long companyId) {
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE_COMPANY, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1,(int)companyId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeCompanyFromFileIntoDB() {
        Company company = new Company();
        List<String> companies = fromFileToList(ReadFile.COMPANIES_PATH);

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