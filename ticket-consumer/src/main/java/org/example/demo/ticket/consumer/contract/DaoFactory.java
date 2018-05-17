package org.example.demo.ticket.consumer.contract;

import org.example.demo.ticket.consumer.contract.dao.ProjetDao;
import org.example.demo.ticket.consumer.contract.dao.TicketDao;
import org.example.demo.ticket.consumer.contract.dao.UtilisateurDao;

/**
 * Created by esspressoh on 04.05.18.
 */
public interface DaoFactory {


    TicketDao getTicketDao();


    ProjetDao getProjetDao();

    UtilisateurDao getUtilisateurDao();
}
