package org.example.demo.ticket.consumer.impl.dao;

import org.example.demo.ticket.consumer.contract.dao.UtilisateurDao;
import org.example.demo.ticket.consumer.impl.rowmapper.projet.UtilisateurRM;
import org.example.demo.ticket.model.bean.utilisateur.Utilisateur;
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
public class UtilisateurDaoImpl extends AbstractDaoImpl implements UtilisateurDao {
    @Override
    public Utilisateur getUtilisateur(Utilisateur id) {

        String vSQL = "SELECT * FROM public.utilisateur WHERE id = :id";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("id", Utilisateur.getId(), Types.INTEGER);

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        RowMapper<Utilisateur> vRowMapper = new UtilisateurRM();

        List<Utilisateur> vUtilisateur = vJdbcTemplate.query(vSQL, vRowMapper);

        return (Utilisateur) vUtilisateur;

    }

}
