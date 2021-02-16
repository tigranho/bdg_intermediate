package com.bdg.homework.traveling.utils;

import com.bdg.homework.traveling.model.Company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.sql.Date;


public class CompanyFileReader {
    private static BufferedReader bufferedReader;
    private static final Set<Company> groups = new HashSet<>();
    public static Set<Company> readListOfCompany(String filePath){
        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));


            String currentLine = bufferedReader.readLine();
            String nextLine = currentLine;
            Date date;
             Company currentCompany;
             String dateStr,nameStr;
            while (nextLine != null) {
				dateStr=currentLine.split(",")[1];
				nameStr=currentLine.split(",")[0];
				
            	date= (Date) new SimpleDateFormat("MM/dd/yyyy").parse(dateStr);
            	currentCompany= new Company(nameStr,   date);
            	groups.add(currentCompany);
				 nextLine= bufferedReader.readLine();
				 currentLine=nextLine;
            }



        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		catch (ParseException e)
		{
			e.printStackTrace();
		} return groups  ;
    }
    
}
