package com.bdg.homework.traveling.utils;

import com.bdg.homework.traveling.model.Company;
import com.bdg.homework.traveling.model.Passenger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

public class PassengerFileReader {
	
	
	private static BufferedReader bufferedReader;
	private static final Set<Passenger> groups = new HashSet<>();
	public static Set<Passenger> readListOfPassenger(String filePath){
		try {
			bufferedReader = new BufferedReader(new FileReader(filePath));
			
			
			String currentLine = bufferedReader.readLine();
			String nextLine = currentLine;
		 
			Passenger currentPassenger;
			String name, country , city;
			int phoneNumber;
			while (nextLine != null) {
				phoneNumber=Integer.parseInt(currentLine.split(",")[1]);
				name=currentLine.split(",")[0];
				country=currentLine.split(",")[2];
				city=currentLine.split(",")[3];
				
 				currentPassenger= new Passenger(name,phoneNumber);
				groups.add(currentPassenger);
				nextLine= bufferedReader.readLine();
				currentLine=nextLine;
			}
			
			
			
		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 return groups  ;
	}
	
}
