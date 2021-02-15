package com.bdg.airport_management_system.model.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.ArrayList;
import java.util.List;

public class ReadFromFile {

    public static final String COMPANIES_PATH = "D:\\\\Users\\\\DANIL\\\\Desktop\\\\homework(JDBC) (1).txt";

    public static List<String> fromFileToList(String file) {
        List<String> listFromFile = new ArrayList<>();

        try {
            listFromFile = Files.readAllLines(Paths.get(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listFromFile;
    }
}
//    public static List<String> ReadFromFileForCompany() {
//        File file = new File("D:\\Users\\DANIL\\Desktop\\homework(JDBC) (1).txt");
//        List<String> companies = new ArrayList<>();
//        try {
//            BufferedReader read = new BufferedReader(new FileReader(file));
//            String company;
//            while ((company = read.readLine()) != null) {
//                companies.add(company);
//                companies.removeIf((name) -> name.equals("name,found_date"));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return companies;
//    }

