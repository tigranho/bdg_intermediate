package airport_management_system.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PgSql {
    public static final String url = "jdbc:postgresql://localhost/ams_db";
    public static final String username = "ruzanna";
    public static final String password = "Q!w2e3r4";

    private static boolean isEmpty(String table) throws SQLException {
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement stm = connection.createStatement()) {
            String sql = "SELECT * FROM " + table;
            ResultSet rs = stm.executeQuery(sql);

            return !rs.next();
        }
    }

    public static void initDatabase() throws SQLException {

        //************ Add Companies from File ************

        if (isEmpty("company")) {
            try (Connection connection = DriverManager.getConnection(url, username, password);
                 PreparedStatement stm = connection.prepareStatement("INSERT INTO company (name, found_date) VALUES (?, ?)")) {


                try (FileReader file = new FileReader(".\\src\\main\\files\\airport_management_system\\companies.txt");
                     BufferedReader buffer = new BufferedReader(file)) {
                    String strCurrentLine;
                    while ((strCurrentLine = buffer.readLine()) != null) {
                        String[] str = strCurrentLine.split(",");
                        LocalDate date = LocalDate.parse(str[1], DateTimeFormatter.ofPattern("M/d/yyyy"));
                        stm.setString(1, str[0]);
                        stm.setDate(2, Date.valueOf(date));
                        stm.addBatch();
                    }
                    stm.executeBatch();
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        //************ Add Countries and Cities from the Passengers File ************

        if (isEmpty("country_city")) {
            try (Connection connection = DriverManager.getConnection(url, username, password);
                 PreparedStatement stm = connection.prepareStatement("INSERT INTO country_city (country, city) VALUES (?, ?)")) {
                try (FileReader file = new FileReader(".\\src\\main\\files\\airport_management_system\\passengers.txt");
                     BufferedReader buffer = new BufferedReader(file)) {
                    List<String> list = new ArrayList<>();
                    String strCurrentLine;
                    while ((strCurrentLine = buffer.readLine()) != null) {
                        String[] temp = strCurrentLine.split(",");
                        String countryCity = temp[2] + "," + temp[3];
                        if (!list.contains(countryCity)) {
                            list.add(countryCity);
                        }
                    }
                    int row = 0;
                    while (row < list.size()) {
                        String[] temp = list.get(row).split(",");
                        stm.setString(1, temp[0]);
                        stm.setString(2, temp[1]);
                        stm.addBatch();
                        row++;
                    }
                    stm.executeBatch();
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }


        //************ Add Passengers from the Passengers File ************
        if (isEmpty("passenger")) {
            String sqlInsert = "INSERT INTO passenger (city_id, name, phone) VALUES (?, ?, ?)";
            String sqlSelect = "SELECT id FROM country_city WHERE country=? AND city=?";
            try (Connection connection = DriverManager.getConnection(url, username, password);
                 PreparedStatement stm1 = connection.prepareStatement(sqlSelect);
                 PreparedStatement stm2 = connection.prepareStatement(sqlInsert)) {
                try (FileReader file = new FileReader(".\\src\\main\\files\\airport_management_system\\passengers.txt");
                     BufferedReader buffer = new BufferedReader(file)) {
                    String strCurrentLine;
                    while ((strCurrentLine = buffer.readLine()) != null) {
                        String[] temp = strCurrentLine.split(",");
                        stm1.setString(1, temp[2]);
                        stm1.setString(2, temp[3]);
                        ResultSet resultSet = stm1.executeQuery();
                        resultSet.next();

                        stm2.setInt(1, resultSet.getInt("id"));
                        stm2.setString(2, temp[0]);
                        stm2.setString(3, temp[1]);
                        stm2.addBatch();
                    }
                    stm2.executeBatch();
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
