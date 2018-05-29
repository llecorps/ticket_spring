package org.example.demo.ticket.business.impl.manager;

import org.example.demo.ticket.consumer.contract.DaoFactory;
import org.springframework.transaction.PlatformTransactionManager;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by esspressoh on 01.05.18.
 */
public  class AbstractManager {


    @Inject
    @Named("txManagerTicket")
    private PlatformTransactionManager platformTransactionManager;

    public PlatformTransactionManager getPlatformTransactionManager()
    {
        return platformTransactionManager;
    }




    @Inject
    private DaoFactory daoFactory;
    protected DaoFactory getDaoFactory()
    {
        return daoFactory;
    }

    public void setDaoFactory(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
}
