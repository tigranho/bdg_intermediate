package com.bdg.airoport.management.system.services;

import java.util.Set;

public interface CompanyService {
    com.bdg.airoport.management.system.model.Company getById(long id);

    Set<com.bdg.airoport.management.system.model.Company> getAll();

    Set<com.bdg.airoport.management.system.model.Company> get(int page, int perPage, String sort);

    com.bdg.airoport.management.system.model.Company save(com.bdg.airoport.management.system.model.Company passenger);

    com.bdg.airoport.management.system.model.Company update(com.bdg.airoport.management.system.model.Company passenger);

    void delete(long companyId);
}
