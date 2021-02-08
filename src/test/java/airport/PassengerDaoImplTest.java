package airport;

import com.bdg.homework.airport.model.Address;
import com.bdg.homework.airport.model.Passenger;
import com.bdg.homework.airport.repository.AddressDao;
import com.bdg.homework.airport.repository.impl.AddressDaoImpl;
import com.bdg.homework.airport.repository.PassengerDao;
import com.bdg.homework.airport.repository.impl.PassengerDaoImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.Set;

class PassengerDaoImplTest {


    @Test
    void getById() {
        PassengerDao passengerDao = new PassengerDaoImpl();
        Passenger passenger = passengerDao.getById(1);
        Assertions.assertNotNull(passenger);
        Assertions.assertEquals(passenger.getName(), "Valod");
    }

    @Test
    void getAll() {
        PassengerDao passengerDao = new PassengerDaoImpl();
        Set<Passenger> passenger = passengerDao.getAll();
        passenger.forEach((pass) -> {
            Assertions.assertNotNull(pass);
        });
    }

    @Test
    void get() {
    }

    @Test
    @Order(1)
    void save() {
        PassengerDao passengerDao= new PassengerDaoImpl();
        AddressDao addressDao= new AddressDaoImpl();
        Address address=new Address("Ijevan","Tavush");
        Address save = addressDao.save(address);
        Passenger passenger= new Passenger("Nikol","37494666777",address);
        Passenger save1 = passengerDao.save(passenger);
        Assertions.assertNotNull(save);
        Assertions.assertNotNull(save1);
        Assertions.assertEquals(save1.getName(),"Nikol");
    }

    @Test
    @Order(2)
    void update() {
        PassengerDao passengerDao= new PassengerDaoImpl();
        AddressDao addressDao= new AddressDaoImpl();
        Address address=new Address("Yeravan","Armenia");
        Address save = addressDao.save(address);
        Passenger passenger=passengerDao.getById(4);
        passenger.setName("Nikol-prikol");
    }

    @Test
    void delete() {
    }

    @Test
    void registerTrip() {
    }

    @Test
    void cancelTrip() {
    }
}
