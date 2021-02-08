package airport_managment_system.service;

import airport_managment_system.model.Company;

import java.util.Set;

public interface Company_function {
    Company getById(int id);
    Set<Company> getAll();
    Set<Company> get(int page, int perPage, String sort);
    Company save(Company passenger);
    Company update(Company passenger);
    void delete(int companyId);
}
