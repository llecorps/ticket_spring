package org.example.demo.ticket.model.recherche.ticket;

/**
 * Created by esspressoh on 16.05.18.
 */
public class RechercheProjet {

    public RechercheProjet() {
    }

    public Integer getProjetId() {
        return projetId;
    }

    public void setProjetId(Integer projetId) {
        this.projetId = projetId;
    }

    public Integer getResponsableId() {
        return responsableId;
    }

    public void setResponsableId(Integer responsableId) {
        this.responsableId = responsableId;
    }

    private Integer projetId;
    private Integer responsableId;


}
