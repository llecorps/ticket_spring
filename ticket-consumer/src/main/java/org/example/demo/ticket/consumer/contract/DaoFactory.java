package org.example.demo.ticket.consumer.contract;

import org.example.demo.ticket.consumer.contract.dao.TicketDao;

/**
 * Created by esspressoh on 04.05.18.
 */
public interface DaoFactory {


    TicketDao getTicketDao();




}
