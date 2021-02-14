package com.bdg.homework.traveling.dataObjAc.daoImpl;

import com.bdg.homework.traveling.connection.DbConnection;
import com.bdg.homework.traveling.dataObjAc.daoInterfaces.CompanyDao;
import com.bdg.homework.traveling.model.Address;
import com.bdg.homework.traveling.model.Company;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

import static java.lang.String.valueOf;

public class CompanyDaoImpl implements CompanyDao {
    @Override
    public Company getById(long id) {
        Company returnedCompany = new Company();
        try(Connection connection= new DbConnection().op()){

            PreparedStatement statement = connection.prepareStatement("select * from company where id=?");
            statement.setLong(1,  id );


            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                returnedCompany.setId(resultSet.getInt("id"));
                returnedCompany.setName(resultSet.getString("name"));
                returnedCompany.setLocaleDate(resultSet.getDate("LocalDate"));
                return returnedCompany;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return returnedCompany;

    }

    @Override
    public Set<Company> getAll() {
    Set<Company> companies= new HashSet<>();
    try(Connection connection= new DbConnection().openConnection();
        PreparedStatement preparedStatement= connection.prepareStatement("SELECT * FROM company")){
      ResultSet resultSet=preparedStatement.executeQuery();
      Company currentCompany;
      while (resultSet.next()){
          currentCompany = new Company();
          currentCompany.setId(resultSet.getInt("id"));
          currentCompany.setName(resultSet.getString("name"));
          currentCompany.setLocaleDate(resultSet.getDate("LocalDate"));

          companies.add(currentCompany);
      }

    }catch (Exception exception){

    }
        return companies;
    }

    @Override
    public Set<Company> get(int page, int perPage, String sort) {
        return null;
    }

    @Override
    public Company save(Company company1) {
        Company company = new Company();
        try(Connection connection= new DbConnection().openConnection();
           PreparedStatement preparedStatement= connection.prepareStatement("insert  into company(name,LocalDate) values (?,?)")) {
            preparedStatement.setString(1, company1.getName());
            preparedStatement.setDate(2,  company1.getLocaleDate());
            preparedStatement.execute();
            try (ResultSet genId = preparedStatement.executeQuery("SELECT * FROM company")) {
                genId.next();
                company.setId(genId.getInt("id"));
                company.setName(genId.getString("name"));
                company.setLocaleDate(genId.getDate("LocalDate"));
            }

        } catch (Exception x) {
            x.printStackTrace();

        }

        return company;
    }

    @Override
    public Company update(Company company,int cuurentId) {
        Company updatedCompany = new Company();

        try(Connection connection= new DbConnection().openConnection();
           PreparedStatement preparedStatement= connection.prepareStatement("update company set name=?,LocalDate=?  where id=?") ){
            preparedStatement.setString(1, company.getName());
            preparedStatement.setDate(2, company.getLocaleDate());
            preparedStatement.setInt(3,cuurentId);
            preparedStatement.executeUpdate();

            ResultSet resultSet= preparedStatement.executeQuery("SELECT * FROM company");
            if (resultSet.next()) {
                updatedCompany.setId(resultSet.getInt("id"));
                updatedCompany.setName(resultSet.getString("name"));
                updatedCompany.setLocaleDate(resultSet.getDate("LocalDate"));
            }

        }catch (Exception x){
             x.printStackTrace();
        }

        return updatedCompany;
    }

    @Override
    public void delete(long companyId) {
        try (Connection connection= new DbConnection().openConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("delete from company where  id=?")){
            preparedStatement.setLong(1, companyId);
            preparedStatement.executeUpdate();
            System.out.println("The company has been deleted " + companyId);

            }catch (Exception e){

        }

    }

}
