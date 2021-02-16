package jdbc.airport;

import com.bdg.homework.jdbc.airport.excpetions.impl.AddressException;
import com.bdg.homework.jdbc.airport.model.Address;
import com.bdg.homework.jdbc.airport.service.AddressService;
import com.bdg.homework.jdbc.airport.service.impl.AddressServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

class AddressServiceImplTest {

    private final AddressService addressService;
    private int addressId;

    public AddressServiceImplTest() {
        addressService = new AddressServiceImpl();
    }


    @Test
    @Order(2)
    void getById() throws AddressException {
        Address byId = addressService.getById(addressId);
        Assertions.assertNotNull(byId);
        Assertions.assertThrows(AddressException.class,()->{
           addressService.getById(-10);
        });
        Assertions.assertThrows(AddressException.class,()->{
            addressService.getById(2);
        });
    }

    @Test
    @Order(1)
    @BeforeEach
    void save() throws AddressException {
        Address address = new Address("Kirovakan", "Armenia");
        Address save = addressService.save(address);
        addressId = save.getId();
        Assertions.assertNotNull(save);
        Address address1 = new Address();
        Assertions.assertThrows(AddressException.class, () -> {
            addressService.save(address1);
        });
    }

}
