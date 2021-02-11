package airport_management_system.dao;

import airport_management_system.model.Company;

import java.util.Set;

public interface CompanyDAO {

    Company getById(long id);
    Set<Company> getAll();
    Set<Company> get(int page, int perPage, String sort);
    Company save(Company company);
    Company update(long companyId, Company company);
    void delete(long companyId);

}
