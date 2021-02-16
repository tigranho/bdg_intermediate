package com.bdg.homework5.dao.impl;

import com.bdg.homework5.entity.Passenger;
import com.bdg.homework5.entity.Trip;
import com.bdg.homework5.dao.TripDAO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



public class TripDAOImpl implements TripDAO {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Hibernate_JPA");
    public static EntityManager getEntityManager(){
        return emf.createEntityManager();
    }

    /**
     *
     * @param id which trip we wnat to get
     * @return trip by that id
     */

    @Override
    public Trip getById(int id) {
            EntityManager em = getEntityManager();
            em.getTransaction().begin();
            Trip trip = em.find(Trip.class, id);
            em.detach(trip);
        return trip;
    }

    /**
     *
     * @return List of all trips
     */
    @Override
    public List<Trip> getAll() {
        List<Trip> trips = new ArrayList<>();
        EntityManager em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        TypedQuery<Trip> query = em.createQuery("SELECT t from Trip t left JOIN FETCH t.company",Trip.class);
        trips = query.getResultList();
        transaction.commit();
        emf.close();
        em.close();
        return trips;
    }

    /**
     *
     * @param page from where to get Trip
     * @param perPage count of trips we wnat to see
     * @param sort order by what
     * @return List of trips
     */

    @Override
    public List<Trip> get(int page, int perPage, String sort) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        String sql = "SELECT t from Trip t order by t.time_in DESC";
        TypedQuery<Trip> query = em.createQuery(sql,Trip.class).setFirstResult(page).setMaxResults(perPage);
        List<Trip> tripSet = query.getResultList();
        em.getTransaction().commit();
        em.close();
        emf.close();

        return tripSet;
    }
    /**
     *
     * @param trip this trip include inside also company
     * @return saved trip
     */
    @Override
    public Trip save(Trip trip) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(trip.getCompany());
        em.persist(trip);
        em.flush();
        em.getTransaction().commit();
        emf.close();
        em.close();
        return trip;
    }
    /**
     * @param trip this is new trip
     * @return updated trip
     */

    @Override
    public Trip update(Trip trip) {
        EntityManager em = getEntityManager();
        Trip trip1 = getById(trip.getId());
        em.detach(trip1);
        trip1.setCompany(trip.getCompany());
        trip1.setTown_to(trip.getTown_to());
        trip1.setTown_from(trip.getTown_from());
        trip1.setTime_in(trip.getTime_in());
        trip1.setTime_out(trip.getTime_out());
        em.getTransaction().begin();
        em.merge(trip1);
        em.flush();
        Trip trip2 = trip1;
        em.getTransaction().commit();
        em.close();
        emf.close();
        return trip1;
    }

    /**
     *
     * @param tripId responsible for deleting the trip by given id
     */

    @Override
    public void delete(int tripId) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Trip trip = em.find(Trip.class, tripId);
        em.remove(trip);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
