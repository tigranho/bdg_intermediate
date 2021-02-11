package airport_management_system_JPA.dao;

import airport_management_system_JPA.model.Company;

import java.util.List;
import java.util.Set;

public interface CompanyDAO {

    Company getById(long id);
    Set<Company> getAll();
    List<Company> get(int page, int perPage, String sort);
    Company save(Company company);
    Company update(long companyId, Company company);
    void delete(long companyId);

}
