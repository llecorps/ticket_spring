package org.example.demo.ticket.consumer.contract.dao;

import org.example.demo.ticket.model.bean.utilisateur.Utilisateur;

/**
 * Created by esspressoh on 16.05.18.
 */
public interface UtilisateurDao {

    Utilisateur getUtilisateur(Utilisateur id);
}
