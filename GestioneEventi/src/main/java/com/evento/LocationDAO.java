package com.evento;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class LocationDAO {

    public void save(Location location) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(location);
        transaction.commit();
        em.close();
    }

    public Location findById(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        Location location = em.find(Location.class, id);
        em.close();
        return location;
    }

    public void delete(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Location location = em.find(Location.class, id);
        if (location != null) {
            em.remove(location);
        }
        transaction.commit();
        em.close();
    }

    public List<Location> findAll() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Location> locations = em.createQuery("FROM Location", Location.class).getResultList();
        em.close();
        return locations;
    }
}
