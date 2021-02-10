package jdbc.airport;

import com.bdg.homework.jdbc.airport.excpetions.impl.AddressException;
import com.bdg.homework.jdbc.airport.excpetions.impl.PassengerException;
import com.bdg.homework.jdbc.airport.model.Address;
import com.bdg.homework.jdbc.airport.model.Passenger;
import com.bdg.homework.jdbc.airport.service.AddressService;
import com.bdg.homework.jdbc.airport.service.PassengerService;
import com.bdg.homework.jdbc.airport.service.impl.AddressServiceImpl;
import com.bdg.homework.jdbc.airport.service.impl.PassengerServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;


class PassengerServiceImplTest {

    private final AddressService addressService;
    private int PASSENGER_ID;
    private int ADDRESS_ID;
    private PassengerService passengerService;

    private PassengerServiceImplTest() {
        passengerService = new PassengerServiceImpl();
        addressService = new AddressServiceImpl();
    }



    @Test()
    @Order(1)
    @BeforeEach
    void save() {
        Address address = new Address("Yerevan", "Armenia");
        Passenger passenger = new Passenger("Poxos poxosyan", "+374665546636", address);
        Passenger passenger1 = new Passenger();
        Assertions.assertThrows(PassengerException.class, () -> {
            passengerService.save(passenger1);
        });
        try {
            Address save = addressService.save(address);
            ADDRESS_ID = save.getId();
            Passenger save1 = passengerService.save(passenger);
            PASSENGER_ID = save1.getId();
            Assertions.assertNotNull(save);
            Assertions.assertNotNull(save1);
        } catch (PassengerException | AddressException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Order(2)
    void getById() {
        Assertions.assertThrows(PassengerException.class, () -> {
            passengerService.getById(1);
        });
        try {
            Assertions.assertNotNull(passengerService.getById(PASSENGER_ID));
        } catch (PassengerException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Order(3)
    void getAll() {
        Assertions.assertNotNull(passengerService.getAll());
    }

    @Test
    void get() {
    }

    @Test
    @Order(4)
    void update() {
        Address address = new Address("São Gabriel", "Brazil");
        address.setId(ADDRESS_ID);
        Passenger passenger = new Passenger("Petros Petrosyan", "+37444556677", address);
        passenger.setId(PASSENGER_ID);
        try {
            Assertions.assertNotNull(passengerService.update(passenger));
        } catch (PassengerException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Order(5)
    void delete() throws PassengerException {
        passengerService.delete(PASSENGER_ID);
        Assertions.assertThrows(PassengerException.class, () -> {
          passengerService.getById(PASSENGER_ID);
        });
    }

    @Test
    void getPassengersOfTrip() {
    }

    @Test
    void registerTrip() {
    }

    @Test
    void cancelTrip() {
    }
}
