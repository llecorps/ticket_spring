package org.example.demo.ticket.batch.impl;

import org.example.demo.ticket.model.bean.ticket.TicketStatut;
import org.example.demo.ticket.model.exception.TechnicalException;

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
//config file
//@Configuration
//@ComponentScan(basePackages = { "org.example.demo.ticket.batch.*" })
//@PropertySource("classpath:config.properties")
public class ExportTicketStatus extends AbstractBatch{

    //@Value(value = "$file.path")
    @Inject
    @Named("exportTicket")
    protected String filePath;

    protected List<TicketStatut> vListTicketStatut;

    //export list TicketStatus
    public ExportTicketStatus() {

        vListTicketStatut = new ArrayList<>();
        vListTicketStatut = getManagerFactory().getTicketManager().getListTicketStatut();


    }



        public void main(String[] pArgs) throws TechnicalException {
        //protected void Ecrire(TicketStatut TicketStatut.toString()
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
            ListIterator it = vListTicketStatut.listIterator();


                while(it.hasNext())
                    System.out.println(it.next());
               // Object entry = it.next();
                TicketStatut vTicketStatut = new TicketStatut();
                //vTicketStatut.setId(entry.id);
                //vTicketStatut.setId(entry.getString("libelle"));

                fw.write (vTicketStatut.toString());
                fw.write ("\r\n");

                fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
