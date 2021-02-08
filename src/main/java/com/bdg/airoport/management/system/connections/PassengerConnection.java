package com.bdg.airoport.management.system.connections;

import com.bdg.airoport.management.system.model.Address;
import com.bdg.airoport.management.system.model.Passenger;
import com.bdg.airoport.management.system.dao.AddressDao;
import com.bdg.airoport.management.system.dao.PassengerDao;
import com.bdg.airoport.management.system.dao.impl.AddressDaoImpl;
import com.bdg.airoport.management.system.dao.impl.PassengerDaoImpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PassengerConnection {
    public static List<String> readDataFromFileForPassenger() {
        File file = new File("D:\\homework\\homework(JDBC)\\passengers.txt");
        List<String> passengers = new ArrayList<>();
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


    public static void writePassengerDaraInDb(List<String> passengers) {
        PassengerDao passengerDao = new PassengerDaoImpl();
        AddressDao addressDao = new AddressDaoImpl();
        passengers.forEach((passenger) -> {
            String[] passengerData = passenger.split(",");
            Address address = new Address(passengerData[3], passengerData[2]);
            Passenger savePassenger = new Passenger(passengerData[0], passengerData[1], address);
            addressDao.save(address);
            passengerDao.save(savePassenger);

        });
    }
}
