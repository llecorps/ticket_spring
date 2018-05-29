package org.example.demo.ticket.consumer.impl;

import org.example.demo.ticket.consumer.contract.DaoFactory;
import org.example.demo.ticket.consumer.contract.dao.UtilisateurDao;
import org.example.demo.ticket.consumer.impl.dao.ProjetDaoImpl;
import org.example.demo.ticket.consumer.impl.dao.TicketDaoImpl;
import org.example.demo.ticket.consumer.impl.dao.UtilisateurDaoImpl;

/**
 * Created by esspressoh on 09.05.18.
 */
public class DaoFactoryImpl implements DaoFactory{
    private ProjetDaoImpl projetDao;
    private TicketDaoImpl ticketDao;



    @Override
    public UtilisateurDao getUtilisateurDao() {
        return new UtilisateurDaoImpl();
    }

    public void setProjetDao(ProjetDaoImpl projetDao) {
        this.projetDao = projetDao;
    }

    public ProjetDaoImpl getProjetDao() {
        return projetDao;
    }

    public void setTicketDao(TicketDaoImpl ticketDao) {
        this.ticketDao = ticketDao;
    }

    public TicketDaoImpl getTicketDao() {
        return ticketDao;
    }
}
