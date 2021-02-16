package com.bdg.homework5.dao.impl;

import com.bdg.homework5.dao.CompanyDAO;
import com.bdg.homework5.entity.Address;
import com.bdg.homework5.entity.Company;
import com.bdg.homework5.entity.Trip;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * this class is responsible for doing crud operations with Company entity
 */
public class CompanyDAOImpl implements CompanyDAO {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Hibernate_JPA");
    public static EntityManager getEntityManager(){
        return emf.createEntityManager();
    }

    /**
     *
     * @param id which comonay we want to find
     * @return company by that id
     */
    @Override
    public Company getById(int id) {
        EntityManager em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        TypedQuery<Company> query = em.createQuery("SELECT a from Company a left JOIN FETCH a.tripSet where a.Id = ?1",Company.class);
        Company c = query.setParameter(1,id).getSingleResult();
        transaction.commit();
        em.close();
        emf.close();

        return c;
    }

    /**
     * @return list of all Companies
     */
    @Override
    public List<Company> getAll() {
        List<Company> trips = new ArrayList<>();
        EntityManager em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        TypedQuery<Company> query = em.createQuery("SELECT c from Company c left JOIN FETCH c.tripSet", Company.class);
        trips = query.getResultList();
        transaction.commit();
        emf.close();
        em.close();
        return trips;
    }

    /**
     *
     * @param page from where to get Company
     * @param perPage count of Companies we want to see
     * @return List of Companies
     */
    @Override
    public List<Company> get(int page, int perPage) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        String sql = "SELECT t from Company t left  join fetch t.tripSet";
        TypedQuery<Company> query = em.createQuery(sql,Company.class).setFirstResult(page).setMaxResults(perPage);
        List<Company> tripSet = query.getResultList();
        em.getTransaction().commit();
        em.close();
        emf.close();

        return tripSet;
    }

    /**
     *
     * @param company this compamy include inside also company
     * @return saved company
     */
    @Override
    public Company save(Company company) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(company);
        em.flush();
        Company c1 = company;
        em.getTransaction().commit();
        emf.close();
        em.close();
        return c1;
    }

    /**
     *
     * @param companyId responsible for deleting the company by given id
     */

    @Override
    public void delete(int companyId) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Company company = em.find(Company.class, companyId);
        em.remove(company);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
