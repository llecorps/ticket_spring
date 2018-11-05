package org.example.demo.ticket.consumer.impl.dao;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

/**
 * Created by esspressoh on 09.05.18.
 */

public  abstract class AbstractDaoImpl {

    @Inject
    @Named("dataSourceTicket")
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
       this.dataSource = dataSource;
    }

    public DataSource getDataSource() {

        return dataSource;
    }


}
