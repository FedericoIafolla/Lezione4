package com.evento;

import java.util.Date;

public class TestEvento {
    public static void main(String[] args) {
        EventoDAO eventoDAO = new EventoDAO();

        Evento evento1 = new Evento("Concerto", new Date(), "Concerto di musica dal vivo", TipoEvento.PUBBLICO, 100);
        eventoDAO.save(evento1);

        Evento evento2 = new Evento("Festa di Compleanno", new Date(), "Festa per il compleanno di Marco", TipoEvento.PRIVATO, 50);
        eventoDAO.save(evento2);

        Evento recuperato = eventoDAO.getById(evento1.getId());
        System.out.println("Evento recuperato: " + recuperato.getTitolo());

        eventoDAO.delete(evento1.getId());
        System.out.println("Evento cancellato.");
    }
}
