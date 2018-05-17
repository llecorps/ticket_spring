package org.example.demo.ticket.consumer.impl.dao;

import org.example.demo.ticket.consumer.contract.dao.UtilisateurDao;
import org.example.demo.ticket.consumer.impl.rowmapper.projet.ProjetRM;
import org.example.demo.ticket.model.bean.projet.Projet;
import org.example.demo.ticket.model.bean.utilisateur.Utilisateur;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 * Created by esspressoh on 16.05.18.
 */
public class UtilisateurDaoImpl extends AbstractDaoImpl implements UtilisateurDao {
    @Override
    public Utilisateur getUtilisateur(Utilisateur id) {

        String vSQL = "SELECT * FROM public.utilisateur WHERE id = :id";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

        RowMapper<Projet> vRowMapper = new ProjetRM();

        Projet vProjet = vJdbcTemplate.query(vSQL, vRowMapper);

        return vProjet;
        return null;
    }
}
