package jdbc.airport;

import com.bdg.homework.jdbc.airport.excpetions.impl.CompanyException;
import com.bdg.homework.jdbc.airport.model.Company;
import com.bdg.homework.jdbc.airport.service.CompanyService;
import com.bdg.homework.jdbc.airport.service.impl.CompanyServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

class CompanyServiceImplTest {

    private final CompanyService service;
    private int companyId;

    public CompanyServiceImplTest() {
        service = new CompanyServiceImpl();
    }


    @Test
    @Order(2)
    void getById() throws CompanyException {
        Company byId = service.getById(companyId);
        Assertions.assertNotNull(byId);
        Assertions.assertThrows(CompanyException.class, () -> {
            service.getById(-10);
        });
        Assertions.assertThrows(CompanyException.class, () -> {
            service.getById(2);
        });
    }

    @Test
    void getAll() {
        Assertions.assertNotNull(service.getAll());
    }

    @Test
    void get() {
    }

    @Test
    @Order(1)
    @BeforeEach
    void save() {
        Company company = new Company("Arshavner club", LocalDate.of(2016, Month.JUNE, 23));
        Company exception = new Company();
        Assertions.assertThrows(CompanyException.class, () -> {
            service.save(exception);
        });
        try {
            Company save = service.save(company);
            companyId = save.getId();
            Assertions.assertNotNull(save);
        } catch (CompanyException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Order(3)
    void update() throws CompanyException {
        Company company = service.getById(companyId);
        company.setName("Arshavigh");
        Company update = service.update(company);
        Assertions.assertNotNull(update);
        companyId = update.getId();
    }

    @Test
    @Order(4)
    void delete() throws CompanyException {
        service.delete(companyId);
        Assertions.assertThrows(CompanyException.class,()->{
            Company company = service.getById(companyId);

        });
    }
}
