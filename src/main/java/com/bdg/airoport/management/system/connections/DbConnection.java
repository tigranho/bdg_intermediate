package com.bdg.airoport.management.system.connections;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnection {
    private static DbConnection connection = null;
    private String driverName;
    private String username;
    private String password;
    private String url;
    private Connection conn=null;

    private DbConnection() {

    }

    public static DbConnection getInstance() {
        if (connection == null) {
            connection = new DbConnection();
        }
        return connection;
    }

    public  Connection getConnection(){
        try {
            readConnectionParams();
            Class.forName(driverName);
            conn= DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }


    private void readConnectionParams() {
        InputStream inputStream = DbConnection.class.getClassLoader().
                getResourceAsStream("config.properties");
        Properties properties = new Properties();

        try {
            if (inputStream != null) {
                properties.load(inputStream);
                driverName = properties.getProperty("driverName");
                username = properties.getProperty("username");
                password = properties.getProperty("password");
                url = properties.getProperty("url");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
