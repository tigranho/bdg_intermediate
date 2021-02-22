package com.bdg.airport_management_JPA.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.ArrayList;
import java.util.List;

public class ReadFile {

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
