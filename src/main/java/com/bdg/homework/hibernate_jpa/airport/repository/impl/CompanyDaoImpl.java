package com.bdg.homework.hibernate_jpa.airport.repository.impl;

import com.bdg.homework.hibernate_jpa.airport.configuration.HibernateUtil;
import com.bdg.homework.hibernate_jpa.airport.model.Company;
import com.bdg.homework.hibernate_jpa.airport.repository.CompanyDao;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class CompanyDaoImpl implements CompanyDao {

    private EntityManager manager = HibernateUtil.entityManager();


    @Override
    public Company getById(int id) {
        Company company = null;
        try {
            manager.getTransaction().begin();
            manager.find(Company.class, id);
            manager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (!(manager == null) && manager.isOpen()) {
                manager.close();
            }
        }
        return company;
    }

    @Override
    public Set<Company> getAll() {
        Set<Company> companies = null;
        try {
            manager.getTransaction().begin();
            Query query = manager.createQuery("select c from Company c", Company.class);
            List<Company> resultList = query.getResultList();
            companies = new TreeSet<>(resultList);
            manager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (!(manager == null) && manager.isOpen()) {
                manager.close();
            }
        }
        return companies;
    }

    @Override
    public Set<Company> get(int page, int perPage, String sort) {
        return null;
    }

    @Override
    public Company save(Company passenger) {
        Company company = null;
        try {
            manager.getTransaction().begin();
            manager.persist(passenger);
            manager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (!(manager == null) && manager.isOpen()) {
                manager.close();
            }
        }
        return company;

    }

    @Override
    public Company update(Company passenger) {
        return null;

    }

    @Override
    public void delete(int companyId) {
    }
}
