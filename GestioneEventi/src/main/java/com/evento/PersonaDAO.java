package com.evento;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class PersonaDAO {

    public void save(Persona persona) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(persona);
        transaction.commit();
        em.close();
    }

    public Persona findById(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        Persona persona = em.find(Persona.class, id);
        em.close();
        return persona;
    }

    public void delete(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Persona persona = em.find(Persona.class, id);
        if (persona != null) {
            em.remove(persona);
        }
        transaction.commit();
        em.close();
    }

    public List<Persona> findAll() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Persona> persone = em.createQuery("FROM Persona", Persona.class).getResultList();
        em.close();
        return persone;
    }
}
