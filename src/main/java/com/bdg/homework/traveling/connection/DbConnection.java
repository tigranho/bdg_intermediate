package com.bdg.homework.traveling.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    public DbConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public Connection openConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/db_travel", "root", "12345");
    }

    public static DbConnection getInstance() {
        return Helper.FACTORY;
    }
    private static class Helper {

        private static DbConnection FACTORY ;

        private Helper(){
            if (FACTORY==null){
                FACTORY= new DbConnection();
            }
        }


    }
}
