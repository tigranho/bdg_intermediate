package com.bdg.homework4.utils.addFromFile;

import com.bdg.homework4.entity.Company;
import com.bdg.homework4.entity.Trip;
import com.bdg.homework4.utils.connect.ConnectToDb;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class AddToDb extends ConnectToDb {

    ReadFromFile readFromFile = new ReadFromFile();


    public void addToAddress() throws Exception {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = null;
            int j = 3;
            for (int i = 2; i < readFromFile.splitAddress().size(); i += 2) {
                preparedStatement = connection.prepareStatement("insert into address(country,city) values(?,?)");
                preparedStatement.setNString(1, readFromFile.splitAddress().get(i));
                preparedStatement.setNString(2, readFromFile.splitAddress().get(j));
                j += 2;
                preparedStatement.executeUpdate();
            }


        } catch (SQLException e) {
            e.getMessage();
        }
    }


    public void addToPassengers() throws Exception {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = null;
            int j = 3;
            int k = 0;
            for (int i = 2;i < readFromFile.splitPassenger().size() ; i += 2) {
                preparedStatement = connection.prepareStatement("insert into passengers(name,phone,address_id) values(?,?,?)");
                preparedStatement.setNString(1, readFromFile.splitPassenger().get(i));
                preparedStatement.setNString(2, readFromFile.splitPassenger().get(j));
                preparedStatement.setInt(3,++k);
                j += 2;
                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            e.getMessage();
        }
    }

    public void addToCompany() throws Exception {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = null;
            int j = 3;
            for (int i = 2; i < readFromFile.splitCompany().size(); i += 2) {
                preparedStatement = connection.prepareStatement("insert into company(name,found_date) values(?,?)");
                preparedStatement.setNString(1, readFromFile.splitCompany().get(i));
                SimpleDateFormat sdfIn = new SimpleDateFormat("dd/MM/yyyy");
                SimpleDateFormat sdfOut = new SimpleDateFormat("yyyy-MM-dd");
                String input = readFromFile.splitCompany().get(j);
                java.util.Date date = sdfIn.parse(input);
                String sDate1 = sdfOut.format(date);
                preparedStatement.setDate(2, java.sql.Date.valueOf(sDate1));
                j += 2;
                preparedStatement.executeUpdate();
            }


        } catch (SQLException e) {
            e.getMessage();
        }
    }

    public void addToTripPass(int pass_id, int trip_id) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "insert into pass_trip(passanger_id,trip_id) values(?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, pass_id);
            preparedStatement.setInt(2, trip_id);
            preparedStatement.executeUpdate();
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

    }

    public void addToTrip(Trip trip) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "insert into trip(time_in,time_out,town_from,town_to,company_id) values(?,?, ?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, trip.getTime_in());
            preparedStatement.setObject(2, trip.getTime_out());
            preparedStatement.setString(3, trip.getTown_from());
            preparedStatement.setString(4, trip.getTown_to());
            preparedStatement.setInt(5, trip.getCompany().getId());

            preparedStatement.executeUpdate();
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
    }

/*
    public static void main(String[] args) {
        AddToDb add = new AddToDb();
        *//*try{
            Trip trip = new Trip();
            Company company = new Company();
            company.setId(150);
            company.setName("Aviaflot");
            company.setDate(java.sql.Date.valueOf("1977-08-08"));

            trip.setCompany(company);
            trip.setTime_in(LocalDateTime.now());
            trip.setTime_out(LocalDateTime.now().plusHours(2));
            trip.setTown_from("Manchester");
            trip.setTown_to("Liverpool");
            add.addToTrip(trip);
        }catch (SQLException e) {
            e.printStackTrace();
        }*//*
            try {
            add.addToTripPass(1, 4);
            add.addToTripPass(28, 5);
            add.addToTripPass(351, 6);
            add.addToTripPass(132, 6);
            add.addToTripPass(13, 7);

        }catch (SQLException e){
            e.printStackTrace();
        }

    }*/
}

