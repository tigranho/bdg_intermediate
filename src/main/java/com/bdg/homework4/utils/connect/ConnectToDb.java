package com.bdg.homework4.utils.connect;

import java.sql.*;

public class ConnectToDb {

   private  final   String url = "jdbc:mysql://localhost:3306/crud";
   private  final String user = "root";
   private  final String password = "0204";


   public  Connection getConnection(){
       Connection conn = null;
       try{
           conn = DriverManager.getConnection(url,user,password);
       }catch (SQLException e){
           e.getMessage();

       }
       return conn;
   }


}
