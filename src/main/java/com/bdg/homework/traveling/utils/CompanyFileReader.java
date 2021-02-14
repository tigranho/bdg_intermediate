package com.bdg.homework.traveling.utils;

import com.bdg.homework.traveling.model.Company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CompanyFileReader {
    private static BufferedReader bufferedReader;
    private static final Set<Company> groups = new HashSet<>();
    public static Set<Company> readListOfCompany(String filePath){
        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));


            String currentLine = bufferedReader.readLine();
            String nextLine = currentLine;

            while (nextLine != null) {

            }



        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null  ;
    };
}
