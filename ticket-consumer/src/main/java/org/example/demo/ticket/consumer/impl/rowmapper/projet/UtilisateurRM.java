package org.example.demo.ticket.consumer.impl.rowmapper.projet;

import org.example.demo.ticket.model.bean.projet.Projet;
import org.example.demo.ticket.model.bean.utilisateur.Utilisateur;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by esspressoh on 16.05.18.
 */
public class UtilisateurRM implements RowMapper<Utilisateur> {
    /**
     * Implementations must implement this method to map each row of data
     * in the ResultSet. This method should not call {@code next()} on
     * the ResultSet; it is only supposed to map values of the current row.
     *
     * @param pRS     the ResultSet to map (pre-initialized for the current row)
     * @param rowNum the number of the current row
     * @return the result object for the current row
     * @throws SQLException if a SQLException is encountered getting
     *                      column values (that is, there's no need to catch SQLException)
     */
    @Override
    public Utilisateur mapRow(ResultSet pRS, int rowNum) throws SQLException {

        Utilisateur vUtilisateur = new Utilisateur(pRS.getInt("id"));


        vUtilisateur.setNom(pRS.getString("nom"));
        vUtilisateur.setNom(pRS.getString("prenom"));

        return vUtilisateur;
    }
}
