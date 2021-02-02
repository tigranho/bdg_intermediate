package com.bdg;

import com.bdg.homework.airport.configuration.DbConnection;

import java.sql.Connection;

/**
 * @author Aram
 */
public class Main {

    public static void main(String[] args) {
        DbConnection dbConnection= DbConnection.getInstance();
        Connection connection= dbConnection.getConnection();
        System.out.println(connection);

    }


}
