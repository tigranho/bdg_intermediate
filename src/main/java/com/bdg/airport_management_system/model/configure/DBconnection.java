package com.bdg.airport_management_system.model.configure;
import java.sql.*;

    public class DBconnection {

        private static final DBconnection instance = new DBconnection();
        public static final String URL = "jdbc:mysql://localhost:3306/user_management";
        public static final String USER = "user_management";
        public static final String PASSWORD = "root";
        public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";


        private DBconnection (){
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



