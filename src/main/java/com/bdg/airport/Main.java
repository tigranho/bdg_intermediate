package com.bdg.airport;

import com.bdg.airport.dao_impl.AddressImpl;
import com.bdg.airport.dao_impl.CompanyImpl;
import com.bdg.airport.dao_impl.PassengerImpl;
import com.bdg.airport.dao_impl.TripImpl;
import com.bdg.airport.jdbc.DBMySql;
import com.bdg.airport.model.Trip;

import java.sql.SQLException;
import java.time.LocalTime;
import java.util.Set;

public class Main {
    public static void main(String args[]) throws SQLException {
        CompanyImpl company = new CompanyImpl();
        PassengerImpl passenger = new PassengerImpl();
        AddressImpl address = new AddressImpl();
        TripImpl trip = new TripImpl();
        DBMySql.createDb();

        trip.create();
        //       address.update(new Address("Armenia","Erevan"));
//        Trip trip1=new Trip(1,1,LocalTime.of(15,15),LocalTime.of(2,10),"Yrevan","Tbilisi");
//        trip.update(trip1);
//        trip.delete(2);
//        trip.save(new Trip(2, LocalTime.of(15,15),LocalTime.of(22,10),"Yrevan","Tbilisi"));
          company.create();
          passenger.create();
          address.create();
//         address.saveAddressFromFile();//         passenger.savePassengersFromFile();
//         company.saveCompanyFromFile();
//        company.save(new Company("Energize Global Service", LocalDate.now()));
//        company.update(new Company(1, "Energize Global Service", LocalDate.now()));
//        Set<Company> set = company.getAll();
//        System.out.println(set.size());
//        passenger.save(new Passenger("Artur", "94230081"));
//

    }
}
