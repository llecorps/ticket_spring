package org.example.demo.ticket.consumer.contract.dao;

import org.example.demo.ticket.model.bean.projet.Projet;
import org.example.demo.ticket.model.bean.projet.Version;

import java.util.List;

/**
 * Created by esspressoh on 16.05.18.
 */
public interface ProjetDao {

    Projet getProjet(Integer id);

    List<Projet> getListProjet();

    public void insertVersion(Version pVersion);
}
