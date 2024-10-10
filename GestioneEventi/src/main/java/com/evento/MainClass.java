package com.evento;

import java.util.Date;

public class MainClass {
    public static void main(String[] args) {
        EventoDAO eventoDAO = new EventoDAO();
        PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO();

        PartitaDiCalcio compleanno = new PartitaDiCalcio();
        compleanno.setDataEvento(new Date());
        compleanno.setDescrizione("Festa di Compleanno per Marco");
        compleanno.setNumeroMassimoPartecipanti(50);
        compleanno.setTipoEvento(TipoEvento.FESTA);
        compleanno.setTitolo("Compleanno di Marco");
        eventoDAO.save(compleanno);

        PartitaDiCalcio partitaDiCalcio = new PartitaDiCalcio();
        partitaDiCalcio.setDataEvento(new Date());
        partitaDiCalcio.setDescrizione("Partita di Calcio tra amici");
        partitaDiCalcio.setNumeroMassimoPartecipanti(22);
        partitaDiCalcio.setTipoEvento(TipoEvento.PARTITA_DI_CALCIO);
        partitaDiCalcio.setTitolo("Partita di Calcio");
        partitaDiCalcio.setSquadraCasa("Squadra A");
        partitaDiCalcio.setSquadraTrasferta("Squadra B");
        eventoDAO.save(partitaDiCalcio);

        GaraDiAtletica garaDiAtletica = new GaraDiAtletica();
        garaDiAtletica.setDataEvento(new Date());
        garaDiAtletica.setDescrizione("Gara di Atletica leggera");
        garaDiAtletica.setNumeroMassimoPartecipanti(100);
        garaDiAtletica.setTipoEvento(TipoEvento.GARA_DI_ATLETICA);
        garaDiAtletica.setTitolo("Gara di Atletica");
        garaDiAtletica.setVincitore("Atleta 1");
        eventoDAO.save(garaDiAtletica);

        Concerto concerto = new Concerto();
        concerto.setDataEvento(new Date());
        concerto.setDescrizione("Concerto della band XYZ");
        concerto.setNumeroMassimoPartecipanti(500);
        concerto.setTipoEvento(TipoEvento.CONCERTO);
        concerto.setTitolo("Concerto XYZ");
        concerto.setInStreaming(true);
        concerto.setGenere(GenereConcerto.ROCK);
        eventoDAO.save(concerto);

        Partecipazione partecipazione1 = new Partecipazione();
        partecipazione1.setEvento(compleanno);
        partecipazione1.setStato(Stato.CONFERMATO);

        Partecipazione partecipazione2 = new Partecipazione();
        partecipazione2.setEvento(compleanno);
        partecipazione2.setStato(Stato.IN_ATTESA);

        partecipazioneDAO.save(partecipazione1);
        partecipazioneDAO.save(partecipazione2);

        System.out.println("Eventi e partecipazioni salvati con successo!");
    }
}
