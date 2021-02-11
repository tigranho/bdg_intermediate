package airport_management_system_JPA.dao.impl;

import airport_management_system_JPA.model.Company;
import airport_management_system_JPA.dao.CompanyDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class CompanyDAOImpl implements CompanyDAO {
    @Override
    public Company getById(long id) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Ams_JPA");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Company company = em.find(Company.class, id);
        em.getTransaction().commit();
        em.close();
        emf.close();

        return company;
    }

    @Override
    public Set<Company> getAll() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Ams_JPA");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Set<Company> companies = new HashSet<>(em.createQuery("select  c from Company c").getResultList());
        em.getTransaction().commit();
        em.close();
        emf.close();

        return companies;
    }

    @Override
    public Set<Company> get(int page, int perPage, String sort) {

        String sqlQuery = "SELECT c FROM Company c ORDER BY c.name " + sort;

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Ams_JPA");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Set<Company> companies = new HashSet<>(em.createQuery(sqlQuery).setFirstResult(page).setMaxResults(perPage).getResultList());

        em.getTransaction().commit();
        em.close();
        emf.close();

        return companies;
    }

    @Override
    public Company save(Company passenger) {
        return null;
    }

    @Override
    public Company update(long companyId, Company passenger) {
        return null;
    }

    @Override
    public void delete(long companyId) {

    }
}
