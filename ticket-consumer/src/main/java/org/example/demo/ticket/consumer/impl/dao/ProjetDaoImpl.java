package org.example.demo.ticket.consumer.impl.dao;

import jdk.internal.instrumentation.Logger;
import org.example.demo.ticket.consumer.contract.dao.ProjetDao;
import org.example.demo.ticket.consumer.contract.dao.TicketDao;
import org.example.demo.ticket.consumer.contract.dao.UtilisateurDao;
import org.example.demo.ticket.consumer.impl.rowmapper.projet.ProjetRM;
import org.example.demo.ticket.model.bean.projet.Projet;
import org.example.demo.ticket.model.bean.projet.Version;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.Types;
import java.util.List;

/**
 * Created by esspressoh on 16.05.18.
 */
@Named
public class ProjetDaoImpl extends AbstractDaoImpl implements ProjetDao {

    private static final Logger LOGGER = null;
    @Inject
    private TicketDao ticketDao;

    @Inject
    private UtilisateurDao utilisateurDao;


    @Override
    public Projet getProjet(Integer pId) {
        String vSQL = "Select * from public.projet WHERE id=:id" ;

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("id", Projet.getId(), Types.INTEGER);

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        //RowMapper<Projet> vRowMapper = new ProjetRM();

        //List<Projet> vProjet = vJdbcTemplate.query(vSQL, vRowMapper);

        Projet vProjet = vJdbcTemplate.queryForObject(vSQL, vParams, Projet.class);

        //return (Projet) vProjet;
        return  vProjet;

    }

    public List<Projet> getListProjet() {
        String vSQL = "SELECT * FROM public.projet";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        RowMapper<Projet> vRowMapper = new ProjetRM();

        List<Projet> vListProjet = vJdbcTemplate.query(vSQL, vRowMapper);

        return vListProjet;
    }

    @Override
    public void insertVersion(Version pVersion) {
        String vSQL = "INSERT INTO version (projet_id,numero) VALUES (:projet_id,:numero) ";

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        BeanPropertySqlParameterSource vParams = new BeanPropertySqlParameterSource(pVersion);
        vParams.registerSqlType("id", Types.INTEGER);
        vParams.registerSqlType("numero", Types.VARCHAR);

        try {
            vJdbcTemplate.update(vSQL, vParams);
        } catch (DuplicateKeyException vEx) {
            LOGGER.error("Le TicketStatut existe déjà ! id=" + pVersion.getProjet(), vEx);
            // ...
        }
    }



}
