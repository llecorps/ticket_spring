package org.example.demo.ticket.batch.impl;

import org.example.demo.ticket.business.contract.manager.ManagerFactory;

/**
 * Created by TheAdmin on 31.12.2018.
 */
public class AbstractBatch {
    private static ManagerFactory managerFactory;

    protected static ManagerFactory getManagerFactory() {
        return managerFactory;
    }
    public static void setManagerFactory(ManagerFactory pManagerFactory) {
        managerFactory = pManagerFactory;
    }
}
