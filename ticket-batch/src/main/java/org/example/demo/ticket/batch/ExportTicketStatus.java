package org.example.demo.ticket.batch;

import org.example.demo.ticket.business.contract.manager.TicketManager;
import org.example.demo.ticket.model.bean.ticket.Ticket;
import org.example.demo.ticket.model.bean.ticket.TicketStatut;
import org.example.demo.ticket.model.recherche.ticket.RechercheTicket;

import java.util.List;

/**
 * Created by esspressoh on 09.05.18.
 */
public class ExportTicketStatus implements TicketManager{

    public ExportTicketStatus() {
    }


//protected void Ecrire(TicketStatut TicketStatut.toString()

    @Override
    public List<Ticket> getListTicket(RechercheTicket pRechercheTicket) {
        return null;
    }

    public List<Ticket> Ecrire(){

    }


}
