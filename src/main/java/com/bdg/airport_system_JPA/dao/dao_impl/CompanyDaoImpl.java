package com.bdg.airport_system_JPA.dao.dao_impl;

import com.bdg.airport_system_JPA.model.Company;
import com.bdg.airport_system_JPA.dao.CompanyDao;
import com.bdg.airport_system_JPA.util.ReadFile;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.bdg.airport_system_JPA.util.ReadFile.fromFileToList;

public class CompanyDaoImpl implements CompanyDao {

    static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Hibernate_JPA");
    static EntityManager entityManager = entityManagerFactory.createEntityManager();
    static Company company = null;
    Set<Company> companySet = new HashSet<>();


    @Override
    public Company getById(long id) {

        entityManager.getTransaction().begin();
        try {
            company = entityManager.find(Company.class, id);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
        return company;
    }

    @Override
    public Set<Company> getAll() {
        entityManager.getTransaction().begin();
        try {
            Query query = entityManager.createQuery("Select e from Company e");
            companySet = (Set<Company>) query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
        return companySet;
    }

    @Override
    public Set<Company> get(int page, int perPage, String sort) {
        return null;
    }

    @Override
    public Company save(Company company) {
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(company);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
        return company;
    }

    @Override
    public Company update(Company company, long companyId) {
        entityManager.getTransaction().begin();
        try {
            CompanyDaoImpl.company = entityManager.find(Company.class, companyId);
            CompanyDaoImpl.company.setName(company.getName());
            CompanyDaoImpl.company.setFoundingDate(company.getFoundingDate());

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
        return CompanyDaoImpl.company;
    }

    @Override
    public void delete(long companyId) {
        entityManager.getTransaction().begin();
        try {
            company = entityManager.find(Company.class, companyId);
            entityManager.remove(company);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
            entityManagerFactory.close();

        }

    }

    @Override
    public void writeCompanyFromFileIntoDB() {

        List<String> companyList = fromFileToList(ReadFile.COMPANIES_PATH);

        entityManager.getTransaction().begin();
        try {
            for (int i = 1; i < companyList.size(); i++) {

                Company company = new Company();
                String[] companiesArray = companyList.get(i).split(",");
                String[] dates = companiesArray[1].split("/");

                LocalDate foundingDate = LocalDate.of(Integer.parseInt(dates[2]),
                        Integer.parseInt(dates[0]),
                        Integer.parseInt(dates[1]));

                company.setName(companiesArray[0]);
                company.setFoundingDate(foundingDate);

                entityManager.persist(company);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.getTransaction().commit();

            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
