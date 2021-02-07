package com.bdg.airport.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DBMySql {
    private static String CREAT_DB_QUERY="CREATE DATABASE IF NOT EXISTS AIRPORT";
    public static void createDb() {
        Connection conn = null;
        PreparedStatement preparedStAdd = null;
        try {
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(JDBC.JdbcInit.DB_URL, JDBC.JdbcInit.USER, JDBC.JdbcInit.PASS);
            System.out.println("Connected database successfully...");
            PreparedStatement preparedStCreateDb = conn.prepareStatement(CREAT_DB_QUERY);
            preparedStCreateDb.executeUpdate();
            System.out.println("Created given database...");
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }
}
