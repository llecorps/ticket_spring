package org.example.demo.ticket.batch.impl;

import org.example.demo.ticket.business.contract.manager.ManagerFactory;
import org.example.demo.ticket.business.impl.ManagerFactoryImpl;
import org.example.demo.ticket.model.bean.ticket.TicketStatut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

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

@Configuration
//@ComponentScan(basePackages = { "org.example.demo.ticket.batch.*" })
@PropertySource("file:${application.home}/conf/config.properties")
@Named("managerFactory")
public class ExportTicketStatus extends AbstractBatch{

    @Value(value = "$file.path")
    //@Inject
    //@Named("configProperty")
    protected String filePath;

    @Inject
    protected ManagerFactory managerfactory = new ManagerFactoryImpl();

    protected List<TicketStatut> vListTicketStatut;


    @Inject
    public ExportTicketStatus(ManagerFactory pManagerFactory) {
        this.managerfactory = pManagerFactory;
    }


        public void getExportTicketStatus() {

        vListTicketStatut = new ArrayList<>();
        vListTicketStatut = getManagerFactory().getTicketManager().getListTicketStatut();
        //vListTicketStatut = managerfactory.getTicketManager().getListTicketStatut();




        File vFile = new File(filePath);

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

    }


}
