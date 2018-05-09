package org.example.demo.ticket.consumer.impl.dao;

import javax.activation.DataSource;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by esspressoh on 09.05.18.
 */
public class AbstractDaoImpl {

    @Inject
    @Named("dataSourceTicket")
    private DataSource datasource;

    public DataSource getDatasource() {
        return datasource;
    }


}
