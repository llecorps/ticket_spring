package org.example.demo.ticket.consumer.impl.rowmapper.projet;

import org.example.demo.ticket.model.bean.projet.Projet;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by esspressoh on 16.05.18.
 */
public class ProjetRM implements RowMapper<Projet> {

    public Projet mapRow(ResultSet pRS, int pRowNum) throws SQLException {

        Projet vProjet = new Projet(pRS.getInt("id"));

        vProjet.setNom(pRS.getString("nom"));
        vProjet.setDateCreation(pRS.getDate("dateCreation"));
        vProjet.setCloture(pRS.getBoolean("cloture"));
        vProjet.setResponsable(pRS.getString("responsable"));

        return vProjet;

    }

}
