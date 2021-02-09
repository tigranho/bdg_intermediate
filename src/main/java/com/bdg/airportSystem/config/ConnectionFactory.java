package com.bdg.airportSystem.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final ConnectionFactory instance = new ConnectionFactory();
    public static final String URL = "jdbc:mysql://127.0.0.1:3306/airport_management";
    public static final String USER = "root";
    public static final String PASSWORD = "root";
    public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";


    private ConnectionFactory (){
        try {
            Class.forName(DRIVER_CLASS);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    private Connection createConnection() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return connection;
    }

    public static Connection getConnection() {
        return instance.createConnection();
    }

}
