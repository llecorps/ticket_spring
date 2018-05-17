package org.example.demo.ticket.consumer.impl.dao;

import org.example.demo.ticket.consumer.contract.dao.ProjetDao;
import org.example.demo.ticket.consumer.impl.rowmapper.projet.ProjetRM;
import org.example.demo.ticket.model.bean.projet.Projet;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.inject.Named;
import java.sql.Types;
import java.util.List;

/**
 * Created by esspressoh on 16.05.18.
 */
@Named
public class ProjetDaoImpl extends AbstractDaoImpl implements ProjetDao {


    @Override
    public Projet getProjet(Projet pProjet) {
        String vSQL = "Select projet.nom,projet.date_creation,projet.cloture,utilisateur.nom,utilisateur.prenom\n" +
                "from projet INNER JOIN utilisateur ON projet.responsable_id = utilisateur.id\n" +
                "WHERE projet.id= :id;";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("id", pProjet.getId(), Types.INTEGER);

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        RowMapper<Projet> vRowMapper = new ProjetRM();

        Projet vProjet = vJdbcTemplate.query(vSQL, vRowMapper);

        return vProjet;

    }

    public List<Projet> getListProjet() {
        String vSQL = "SELECT * FROM public.projet";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        RowMapper<Projet> vRowMapper = new ProjetRM();

        List<Projet> vListProjet = vJdbcTemplate.query(vSQL, vRowMapper);

        return vListProjet;
    }



}
