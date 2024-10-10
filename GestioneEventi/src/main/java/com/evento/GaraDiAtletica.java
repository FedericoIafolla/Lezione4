package com.evento;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "gare_di_atletica")
public class GaraDiAtletica extends Evento {

    private String vincitore;

    public GaraDiAtletica() {
    }

    public GaraDiAtletica(String titolo, Date dataEvento, String descrizione, int numeroMassimoPartecipanti, String vincitore) {
        super(titolo, dataEvento, descrizione, TipoEvento.GARA_DI_ATLETICA, numeroMassimoPartecipanti);
        this.vincitore = vincitore;
    }

    public String getVincitore() {
        return vincitore;
    }

    public void setVincitore(String vincitore) {
        this.vincitore = vincitore;
    }
}
