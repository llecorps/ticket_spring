package org.example.demo.ticket.consumer.contract.dao;

import org.example.demo.ticket.model.bean.ticket.Ticket;
import org.example.demo.ticket.model.bean.ticket.TicketStatut;
import org.example.demo.ticket.model.recherche.ticket.RechercheTicket;

import java.util.List;

/**
 * Created by esspressoh on 09.05.18.
 */
public interface TicketDao {

    List<TicketStatut> getListStatut();
    int getCountTicket(RechercheTicket pRechercheTicket);


    void updateTicket(Ticket pTicket);

    void updateTicketStatut(TicketStatut pTicketStatut);
}
