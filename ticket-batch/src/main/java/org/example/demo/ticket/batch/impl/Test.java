package org.example.demo.ticket.batch.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.example.demo.ticket.batch.Main;
import org.example.demo.ticket.business.contract.manager.ManagerFactory;
import org.example.demo.ticket.model.bean.ticket.TicketStatut;
import org.example.demo.ticket.model.exception.TechnicalException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.example.demo.ticket.batch.impl.AbstractBatch.getManagerFactory;

/**
 * Created by esspressoh on 30.05.18.
 */
public class Test {

    /** Logger pour la classe */
    private static final Log LOGGER = LogFactory.getLog(Main.class);

    public static void main(String[] pArgs) throws TechnicalException {



        ApplicationContext vApplicationContext
                = new ClassPathXmlApplicationContext("classpath:/bootstrapContext.xml");

        ManagerFactory vManagerFactory = vApplicationContext.getBean("managerFactory",ManagerFactory.class);

        Properties ticketStatusConfiguration = vApplicationContext.getBean("ticketStatutConfiguration", Properties.class);

        //ExportTicketStatus myconfig =(ExportTicketStatus)vApplicationContext.getBean("Myrep");

        /*
        ExportTicketStatus vExportTicketStatus = new ExportTicketStatus(vManagerFactory);
        SystemSettings pSystemSettings = new SystemSettings();
        vExportTicketStatus.getExportTicketStatus();
*/
       // SpringJavaConfigurator pSpringJavaConfigurator = new SpringJavaConfigurator();
        //SystemSettings pSystemSettings = new SystemSettings();
        //System.out.println("mon application est ="+pSpringJavaConfigurator.getSystemSettings());


        List<TicketStatut> vListTicketStatut = new ArrayList<>();
        vListTicketStatut = getManagerFactory().getTicketManager().getListTicketStatut();

        String batchDataFolderPath = vApplicationContext.getEnvironment().getProperty("application.home");
        String filePath = batchDataFolderPath + ticketStatusConfiguration.getProperty("ticketStatusExportPath");


        File exportFile = new File(filePath);

        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
            FileOutputStream fos = new FileOutputStream(exportFile);

            for(TicketStatut ts : vListTicketStatut) {
                fos.write(ts.toString().getBytes());
                fos.write("\n".getBytes());
                LOGGER.info(ts.toString());
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }


    }


}
