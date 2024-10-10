package com.evento;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "partite_di_calcio")
@NamedQueries({
        @NamedQuery(name = "PartitaDiCalcio.getPartiteVinteInCasa", query = "SELECT p FROM PartitaDiCalcio p WHERE p.esito = 'Vinta in casa'"),
        @NamedQuery(name = "PartitaDiCalcio.getPartiteVinteInTrasferta", query = "SELECT p FROM PartitaDiCalcio p WHERE p.esito = 'Vinta in trasferta'"),
        @NamedQuery(name = "PartitaDiCalcio.getPartitePareggiate", query = "SELECT p FROM PartitaDiCalcio p WHERE p.esito = 'Pareggiata'")
})
public class PartitaDiCalcio extends Evento {

    private String squadraCasa;

    private String squadraTrasferta;

    private String esito;

    public PartitaDiCalcio() {
    }

    public PartitaDiCalcio(String titolo, Date dataEvento, String descrizione, int numeroMassimoPartecipanti, String squadraCasa, String squadraTrasferta, String esito) {
        super(titolo, dataEvento, descrizione, TipoEvento.PARTITA_DI_CALCIO, numeroMassimoPartecipanti);
        this.squadraCasa = squadraCasa;
        this.squadraTrasferta = squadraTrasferta;
        this.esito = esito;
    }

    public String getSquadraCasa() {
        return squadraCasa;
    }

    public void setSquadraCasa(String squadraCasa) {
        this.squadraCasa = squadraCasa;
    }

    public String getSquadraTrasferta() {
        return squadraTrasferta;
    }

    public void setSquadraTrasferta(String squadraTrasferta) {
        this.squadraTrasferta = squadraTrasferta;
    }

    public String getEsito() {
        return esito;
    }

    public void setEsito(String esito) {
        this.esito = esito;
    }
}
