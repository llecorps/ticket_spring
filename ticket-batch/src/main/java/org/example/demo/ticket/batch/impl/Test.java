package org.example.demo.ticket.batch.impl;

import org.example.demo.ticket.business.contract.manager.ManagerFactory;
import org.example.demo.ticket.model.exception.TechnicalException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by esspressoh on 30.05.18.
 */
public class Test {

    public static void main(String[] pArgs) throws TechnicalException {

        ApplicationContext vApplicationContext
                = new ClassPathXmlApplicationContext("classpath:/bootstrapContext.xml");

        ManagerFactory vManagerFactory = vApplicationContext.getBean("managerFactory",ManagerFactory.class);

        ExportTicketStatus vExportTicketStatus = new ExportTicketStatus(vManagerFactory);
        vExportTicketStatus.getExportTicketStatus();

    }


}
