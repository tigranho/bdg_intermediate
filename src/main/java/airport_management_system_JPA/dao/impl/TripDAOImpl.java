package airport_management_system_JPA.dao.impl;

import airport_management_system_JPA.dao.TripDAO;
import airport_management_system_JPA.model.Company;
import airport_management_system_JPA.model.Trip;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TripDAOImpl implements TripDAO {
    @Override
    public Trip getById(long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Ams_JPA");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Trip trip = em.find(Trip.class, id);
        em.getTransaction().commit();
        em.close();
        emf.close();
        return trip;
    }

    @Override
    public Set<Trip> getAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Ams_JPA");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Set<Trip> trips = new HashSet<>(em.createQuery("select  t from Trip t").getResultList());

        em.getTransaction().commit();
        em.close();
        emf.close();

        return trips;
    }

    @Override
    public List<Trip> get(int page, int perPage, String sort) {
        String sqlQuery = "SELECT t FROM Trip t ORDER BY t.timeIn " + sort;

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Ams_JPA");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        List<Trip> ls = em.createQuery(sqlQuery).setFirstResult(page*perPage).setMaxResults(perPage).getResultList();

        em.getTransaction().commit();
        em.close();
        emf.close();
        return ls;
    }

    @Override
    public Trip save(Trip passenger) {
        return null;
    }

    @Override
    public Trip update(long tripId, Trip trip) {
        return null;
    }

    @Override
    public void delete(long tripId) {

    }

    @Override
    public List<Trip> getTripsFrom(String city) {
        return null;
    }

    @Override
    public List<Trip> getTripsTo(String city) {
        return null;
    }
}
