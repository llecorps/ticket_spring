package org.example.demo.ticket.business.impl.manager;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by esspressoh on 01.05.18.
 */
public abstract class AbstractManager {


    @Inject
    @Named("txManagerTicket")
    private platformTransactionManager platformTransactionManager;

    public platformTransactionManager getPlatformTransactionManager() {
        return platformTransactionManager;
    }




    @Inject
    private DaoFactory daoFactory;
    protected DaoFactory getDaoFactory() {
        return daoFactory;
    }

    public void setDaoFactory(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
}
