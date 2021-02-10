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


    private final Connection connection = ConnectionFactory.getConnection();



    @Override
    public Company getById(int id) {
        Company company = null;

        try {
            PreparedStatement statement = connection.prepareStatement("select * from company where id=?");
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
            PreparedStatement statement = connection.prepareStatement("select * from company");
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
            PreparedStatement statement = connection.prepareStatement("insert  into company(name,founding_date) values (?,?)", Statement.RETURN_GENERATED_KEYS);
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
           PreparedStatement statement = connection.prepareStatement("update company set name=?,founding_date=?  where id=?", Statement.RETURN_GENERATED_KEYS);
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
            PreparedStatement statement = connection.prepareStatement("delete from company where  id=?", Statement.RETURN_GENERATED_KEYS);
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
            for (int i = 1; i<companies.size(); i++) {

                String[] companiesArray = companies.get(i).split(",");
                String[] dates = companiesArray[1].split("/");

                LocalDate foundingDate = LocalDate.of(Integer.parseInt(dates[2]),
                        Integer.parseInt(dates[0]),
                        Integer.parseInt(dates[1]));

                company.setName(companiesArray[0]);
                company.setFoundingDate(foundingDate);

                PreparedStatement preparedStatement = connection.prepareStatement("insert  into company(name,founding_date) values (?,?)");
                preparedStatement.setString(1, company.getName());
                preparedStatement.setObject(2, company.getFoundingDate());
                preparedStatement.executeUpdate();

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}