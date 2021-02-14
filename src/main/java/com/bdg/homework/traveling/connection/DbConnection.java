package com.bdg.homework.traveling.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    private Connection connection = null;

    public DbConnection() {
    }

    public Connection op() {

        try { connection = openConnection();

        } catch (Exception x) {
            x.printStackTrace();
        }
        return connection;
    }

    public Connection openConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/db_travel", "root", "12345");
    }

}
