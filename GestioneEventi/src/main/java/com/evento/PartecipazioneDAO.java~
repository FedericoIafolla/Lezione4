package com.evento;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class PartecipazioneDAO {

    public void save(Partecipazione partecipazione) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(partecipazione);
        transaction.commit();
        em.close();
    }

    public Partecipazione findById(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        Partecipazione partecipazione = em.find(Partecipazione.class, id);
        em.close();
        return partecipazione;
    }

    public void delete(Partecipazione partecipazione) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(em.contains(partecipazione) ? partecipazione : em.merge(partecipazione));
        transaction.commit();
        em.close();
    }

    public List<Partecipazione> findAll() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Partecipazione> partecipazioni = em.createQuery("FROM Partecipazione", Partecipazione.class).getResultList();
        em.close();
        return partecipazioni;
    }
}
