package com.bdg.airport_management_system;


import java.sql.*;


public class DbConnection {
    private static String mySql = "jdbc:mysql://localhost:3306/airport";
    private static String userName = "root";
    private static String password = "098237874hakob";
    private static final DbConnection instance = new DbConnection();


    public Connection dbConection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(mySql, userName, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from passenger");


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;

    }
}


