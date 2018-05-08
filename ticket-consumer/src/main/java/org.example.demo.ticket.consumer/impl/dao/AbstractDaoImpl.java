package org.example.demo.ticket.consumer.impl.dao;

import javax.sql.DataSource;
import javax.inject.Inject;
import javax.inject.Named;

public abstract class AbstractDaoImpl {

    @Inject
    @Named("dataSourceTicket")
    private DataSource dataSource;

    protected DataSource getDataSource() {
        return dataSource;
    }

    // ...
}