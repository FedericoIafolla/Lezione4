package com.evento;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
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

    // Metodo JPQL per ottenere le partecipazioni da confermare per un evento specifico
    public List<Partecipazione> getPartecipazioniDaConfermarePerEvento(Evento evento) {
        EntityManager em = JPAUtil.getEntityManager();
        TypedQuery<Partecipazione> query = em.createQuery("SELECT p FROM Partecipazione p WHERE p.evento = :evento AND p.stato = :stato", Partecipazione.class);
        query.setParameter("evento", evento);
        query.setParameter("stato", Stato.IN_ATTESA);
        List<Partecipazione> partecipazioni = query.getResultList();
        em.close();
        return partecipazioni;
    }
}
