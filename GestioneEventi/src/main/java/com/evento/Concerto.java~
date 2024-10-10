package com.evento;

import jakarta.persistence.*;
import java.util.Date; // Importa la classe Date

@Entity
@Table(name = "concerti")
public class Concerto extends Evento {

    private boolean inStreaming;

    @Enumerated(EnumType.STRING)
    private GenereConcerto genere;

    public Concerto() {
    }

    public Concerto(String titolo, Date dataEvento, String descrizione, int numeroMassimoPartecipanti, boolean inStreaming, GenereConcerto genere) {
        super(titolo, dataEvento, descrizione, TipoEvento.CONCERTO, numeroMassimoPartecipanti);
        this.inStreaming = inStreaming;
        this.genere = genere;
    }

    public boolean isInStreaming() {
        return inStreaming;
    }

    public void setInStreaming(boolean inStreaming) {
        this.inStreaming = inStreaming;
    }

    public GenereConcerto getGenere() {
        return genere;
    }

    public void setGenere(GenereConcerto genere) {
        this.genere = genere;
    }
}
