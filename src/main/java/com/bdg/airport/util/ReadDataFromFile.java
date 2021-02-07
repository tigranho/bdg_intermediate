package com.bdg.airport.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class ReadDataFromFile {
    public static final String PATH_PASSENGERS="src/main/resources/passengers.txt";
    public static final String PATH_COMPANIES="src/main/resources/companies.txt";
    public static List<String> readFile(String file) {

        List<String> lines = Collections.emptyList();

        try {
            lines = Files.readAllLines(Paths.get(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}
