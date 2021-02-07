package com.bdg;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Aram
 */
public class Main {

    public static void main(String[] args) {
//        TripDao tripDao = new TripDaoImpl();
//        CompanyDao companyDao = new CompanyDaoImpl();
//        Company company = companyDao.getById(2);
//        Trip trip = new Trip(company, LocalDateTime.of(2020, Month.JUNE, 12, 15, 33), LocalDateTime.of(2021, Month.JUNE, 23, 12, 33), "cc", "dd");
//        System.out.println(tripDao.save(trip));

        File file = new File("C:\\Users\\arammi\\Downloads\\homework(JDBC)\\companies.txt");
        List<String> list = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(file));) {
         String s;
            while ((s=reader.readLine())!=null){
                list.add(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

//
//        list.forEach(el->{
//            System.out.println(el   );
//        });



    }


}
