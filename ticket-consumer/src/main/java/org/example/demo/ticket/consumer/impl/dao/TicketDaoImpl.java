package org.example.demo.ticket.consumer.impl.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.example.demo.ticket.consumer.contract.dao.ProjetDao;
import org.example.demo.ticket.consumer.contract.dao.TicketDao;
import org.example.demo.ticket.consumer.contract.dao.UtilisateurDao;
import org.example.demo.ticket.model.bean.ticket.Ticket;
import org.example.demo.ticket.model.bean.ticket.TicketStatut;
import org.example.demo.ticket.model.recherche.ticket.RechercheTicket;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
//import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.LogManager;


@Named
public class TicketDaoImpl extends AbstractDaoImpl implements TicketDao {





    /** Logger pour la classe */
    private static final Log LOGGER = LogFactory.getLog(TicketDaoImpl.class);

    @Inject
    private ProjetDao projetDao;

    @Inject
    private UtilisateurDao utilisateurDao;

    public TicketDaoImpl(){
        super();
    }

    @Override
    public int getCountTicket(RechercheTicket pRechercheTicket) {
        MapSqlParameterSource vParams = new MapSqlParameterSource();

        StringBuilder vSQL = new StringBuilder("SELECT COUNT(*) FROM ticket WHERE 1=1");

        if (pRechercheTicket != null) {
            if (pRechercheTicket.getAuteurId() != null) {
                vSQL.append(" AND auteur_id = :auteur_id");
                vParams.addValue("auteur_id", pRechercheTicket.getAuteurId());
            }
            if (pRechercheTicket.getProjetId() != null) {
                vSQL.append(" AND projet_id = :projet_id");
                vParams.addValue("projet_id", pRechercheTicket.getProjetId());
            }
        }

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        int vNbrTicket = vJdbcTemplate.queryForObject(vSQL.toString(), vParams, Integer.class);

        return vNbrTicket;
    }

    @Override
    public void updateTicket(Ticket pTicket) {

    }


    @Override
    public List<TicketStatut> getListStatut() {
        //String vSQL = "SELECT * FROM public.statut";

        //MapSqlParameterSource vParams = new MapSqlParameterSource();
        //vParams.addValue("id", TicketStatut.getId(), Types.INTEGER);


        //RowMapper<TicketStatut> vRowMapper = new TicketStatutRM();

        //NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        //List<TicketStatut> vListStatut = vJdbcTemplate.query(vSQL, vRowMapper);


            //JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

            //List<TicketStatut> vListStatut = vJdbcTemplate.queryForObject(
             //       "SELECT * FROM public.statut",
              //      ArrayList.class);

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

        List<TicketStatut> vListStatut = vJdbcTemplate.queryForObject(
                      "SELECT * FROM public.statut",
                     ArrayList.class);
        return vListStatut;

    }

    @Override
    public void updateTicketStatut(TicketStatut pTicketStatut) {
        String vSQL = "UPDATE statut SET libelle = :libelle WHERE id = :id";


        BeanPropertySqlParameterSource vParams = new BeanPropertySqlParameterSource(pTicketStatut);
        vParams.registerSqlType("id", Types.INTEGER);
        vParams.registerSqlType("libelle", Types.VARCHAR);


        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        int vNbrLigneMaJ = vJdbcTemplate.update(vSQL, vParams);
    }

    public void insertTicketStatut(TicketStatut pTicketStatut) {
        String vSQL = "INSERT INTO statut (id, libelle) VALUES (:id, :libelle)";
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        BeanPropertySqlParameterSource vParams = new BeanPropertySqlParameterSource(pTicketStatut);
        vParams.registerSqlType("id", Types.INTEGER);
        vParams.registerSqlType("libelle", Types.VARCHAR);

        try {
            vJdbcTemplate.update(vSQL, vParams);
        } catch (DuplicateKeyException vEx) {
            LOGGER.error("Le TicketStatut existe déjà ! id=" + pTicketStatut.getId(), vEx);
            // ...
        }
    }


    public void setDataSourceTicket(org.apache.commons.dbcp2.BasicDataSource dataSourceTicket) {
    }
}