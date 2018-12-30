package org.example.demo.ticket.batch.impl;

import org.example.demo.ticket.business.contract.manager.ManagerFactory;
import org.example.demo.ticket.business.impl.ManagerFactoryImpl;
import org.example.demo.ticket.model.bean.ticket.TicketStatut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by esspressoh on 09.05.18.
 */


@Named("managerFactory")
@Configuration
@PropertySource("classpath:config.properties")
@ComponentScan(basePackages = "*" )
public class ExportTicketStatus extends AbstractBatch{

   @Autowired
   Environment env;

    @Qualifier("config")
    @Autowired
    @Lazy
    private SystemSettings systemSettings;



    //@Inject
    //@Named("configProperty")


    //protected String filePath = "/tmp/test_export_ticket_status.txt";


    //@Value("${rep.name}")
    //public String filePath=mybean.getMyrep();

    public String filePath;


    @Inject
    protected ManagerFactory managerfactory = new ManagerFactoryImpl();

    protected List<TicketStatut> vListTicketStatut;



    @Inject
    public ExportTicketStatus(ManagerFactory pManagerFactory) {


        this.managerfactory = pManagerFactory;

    }




        @Bean
        public SystemSettings getExportTicketStatus() {

            //SystemSettings pSystemSettings = new SystemSettings();
            ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
            SystemSettings mybean=(SystemSettings)ctx.getBean("config");
            String appDisplayName = mybean.getMyrep();

            //String filePath = env.getProperty("rep.name");
        vListTicketStatut = new ArrayList<>();
        vListTicketStatut = getManagerFactory().getTicketManager().getListTicketStatut();
        //vListTicketStatut = managerfactory.getTicketManager().getListTicketStatut();

            System.out.println("filePath="+appDisplayName);



        File vFile = new File(appDisplayName);

        //Object[] obj = vListTicketStatut.toArray();

        try {
            FileWriter fw = new FileWriter(vFile,true);
            /*for (String s : obj)
            for (ArrayList v : vListTicketStatut)
            {

                fw.write (String.valueOf (v));
                fw.write ("\r\n");

            }*/
            TicketStatut vTicketStatut = new TicketStatut();
            ListIterator it = vListTicketStatut.listIterator();


                while(it.hasNext())
                    System.out.println(it.next());
               // Object entry = it.next();

                //vTicketStatut.setId(it.
                //vTicketStatut.setId(entry.getString("libelle"));

                fw.write (vTicketStatut.toString());

                fw.write ("\r\n");

                fw.close();

        } catch (IOException e) {
            e.printStackTrace();

        }

            return mybean;
        }

}
