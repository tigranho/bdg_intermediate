package com.bdg.homework4.utils.addFromFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReadFromFile {
    public List<String> splitAddress(){
        List<String> arrayListAddress = new ArrayList<>();
        try {
            BufferedReader bufferedReader =
                    new BufferedReader(new FileReader("C:\\Users\\comp\\OneDrive\\Desktop\\passengers.txt"));
            String line;
            while((line = bufferedReader.readLine()) != null){
                arrayListAddress.add(line.split(",")[2]);
                arrayListAddress.add(line.split(",")[3]);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return arrayListAddress;
    }

    public List<String> splitPassenger(){
        List<String> arrayListPassenger = new ArrayList<>();
        try {
            BufferedReader bufferedReader =
                    new BufferedReader(new FileReader("C:\\Users\\comp\\OneDrive\\Desktop\\passengers.txt"));
            String line;
            while((line = bufferedReader.readLine()) != null){
                arrayListPassenger.add(line.split(",")[0]);
                arrayListPassenger.add(line.split(",")[1]);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return arrayListPassenger;
    }

    public List<String> splitCompany(){
        List<String> arrayListCompany = new ArrayList<>();
        try {
            BufferedReader bufferedReader =
                    new BufferedReader(new FileReader("C:\\Users\\comp\\OneDrive\\Desktop\\companies.txt"));
            String line;
            while((line = bufferedReader.readLine()) != null){
                arrayListCompany.add(line.split(",")[0]);
                arrayListCompany.add(line.split(",")[1]);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return arrayListCompany;
    }
}
