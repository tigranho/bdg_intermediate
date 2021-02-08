package airport_managment_system.read_write;

import airport_managment_system.model.Address;
import airport_managment_system.model.Company;
import airport_managment_system.model.Passenger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Read_Write {
    public static List<String> readDataFromFileForPassenger() {
        List<String> passengers = new ArrayList<>();
        File file = new File("C:\\Users\\ANNA\\Desktop\\java book\\homework(JDBC)\\companies.txt");

        try {
            BufferedReader read = new BufferedReader(new FileReader(file));
            String passenger;
            while ((passenger = read.readLine()) != null) {
                passengers.add(passenger);
                passengers.removeIf((name) -> name.equals("name,phone,country,city"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return passengers;
    }




    public static List<String> readDataFromFileForCompany() {
        List<String> companies = new ArrayList<>();
        File file = new File("\\Users\\ANNA\\Desktop\\java book\\homework(JDBC)\\passengers.txt");

        try {
            BufferedReader read = new BufferedReader(new FileReader(file));
            String company;
            while ((company = read.readLine()) != null) {
                companies.add(company);
                companies.removeIf((name) -> name.equals("name,found_date"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return companies;
    }




}
