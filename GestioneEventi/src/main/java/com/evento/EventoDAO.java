package com.evento;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class EventoDAO {

    private EntityManagerFactory entityManagerFactory;

    public EventoDAO() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("gestioneeventiPU");
    }

    public void save(Evento evento) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(evento);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Evento getById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Evento evento = entityManager.find(Evento.class, id);
        entityManager.close();
        return evento;
    }

    public void delete(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Evento evento = entityManager.find(Evento.class, id);
        if (evento != null) {
            entityManager.remove(evento);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<Concerto> getConcertiInStreaming(boolean inStreaming) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<Concerto> query = entityManager.createQuery("SELECT c FROM Concerto c WHERE c.inStreaming = :inStreaming", Concerto.class);
        query.setParameter("inStreaming", inStreaming);
        List<Concerto> concerti = query.getResultList();
        entityManager.close();
        return concerti;
    }

    public List<Concerto> getConcertiPerGenere(GenereConcerto genere) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<Concerto> query = entityManager.createQuery("SELECT c FROM Concerto c WHERE c.genere = :genere", Concerto.class);
        query.setParameter("genere", genere);
        List<Concerto> concerti = query.getResultList();
        entityManager.close();
        return concerti;
    }

    public List<PartitaDiCalcio> getPartiteVinteInCasa() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<PartitaDiCalcio> query = entityManager.createNamedQuery("PartitaDiCalcio.getPartiteVinteInCasa", PartitaDiCalcio.class);
        List<PartitaDiCalcio> partite = query.getResultList();
        entityManager.close();
        return partite;
    }

    public List<PartitaDiCalcio> getPartiteVinteInTrasferta() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<PartitaDiCalcio> query = entityManager.createNamedQuery("PartitaDiCalcio.getPartiteVinteInTrasferta", PartitaDiCalcio.class);
        List<PartitaDiCalcio> partite = query.getResultList();
        entityManager.close();
        return partite;
    }

    public List<PartitaDiCalcio> getPartitePareggiate() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<PartitaDiCalcio> query = entityManager.createNamedQuery("PartitaDiCalcio.getPartitePareggiate", PartitaDiCalcio.class);
        List<PartitaDiCalcio> partite = query.getResultList();
        entityManager.close();
        return partite;
    }

    public List<GaraDiAtletica> getGareDiAtleticaPerVincitore(Persona vincitore) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<GaraDiAtletica> query = entityManager.createQuery("SELECT g FROM GaraDiAtletica g WHERE g.vincitore = :vincitore", GaraDiAtletica.class);
        query.setParameter("vincitore", vincitore);
        List<GaraDiAtletica> gare = query.getResultList();
        entityManager.close();
        return gare;
    }

    public List<GaraDiAtletica> getGareDiAtleticaPerPartecipante(Persona partecipante) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<GaraDiAtletica> query = entityManager.createQuery("SELECT g FROM GaraDiAtletica g JOIN g.partecipazioni p WHERE p.persona = :partecipante", GaraDiAtletica.class);
        query.setParameter("partecipante", partecipante);
        List<GaraDiAtletica> gare = query.getResultList();
        entityManager.close();
        return gare;
    }

    public void close() {
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }
}
