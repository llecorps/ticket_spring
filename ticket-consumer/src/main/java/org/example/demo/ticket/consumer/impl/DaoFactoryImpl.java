package org.example.demo.ticket.consumer.impl;

import org.example.demo.ticket.consumer.contract.DaoFactory;
import org.example.demo.ticket.consumer.contract.dao.TicketDao;
import org.example.demo.ticket.consumer.impl.dao.TicketDaoImpl;

/**
 * Created by esspressoh on 09.05.18.
 */
public class DaoFactoryImpl implements DaoFactory{
    @Override
    public TicketDao getTicketDao(){

        return new TicketDaoImpl();
    }
}
