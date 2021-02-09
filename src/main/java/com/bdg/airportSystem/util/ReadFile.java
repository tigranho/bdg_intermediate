package com.bdg.airportSystem.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
    public static final String PASSENGERS_PATH = "src/main/java/com/bdg/airportSystem/resources/passengers.txt";
    public static final String COMPANIES_PATH = "src/main/java/com/bdg/airportSystem/resources/companies.txt";

    public static List<String> fromFileToList(String file){
        List<String> listFromFile = new ArrayList<>();

        try {
            listFromFile = Files.readAllLines(Paths.get(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listFromFile;
    }
}
