package org.example.demo.ticket.business.impl.manager;

import org.example.demo.ticket.business.contract.manager.ProjetManager;
import org.example.demo.ticket.model.bean.projet.Projet;
import org.example.demo.ticket.model.bean.utilisateur.Utilisateur;
import org.example.demo.ticket.model.exception.NotFoundException;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
public class ProjetManagerImpl extends AbstractManager implements ProjetManager {

	/**
     * Renvoie le projet demandé
     *
     * @param pId l'identifiant du projet
     * @return Le {@link Projet}
     * @throws NotFoundException Si le projet n'est pas trouvé
     */
    @Inject
    @Named("txManagerTicket")
    private PlatformTransactionManager platformTransactionManager;


    @Override
	public Projet getProjet(Projet pId) throws NotFoundException {
        /*Je n'ai pas encore codé la DAO
        // Je mets juste un code temporaire pour commencer le cours...
        if (pId < 1) {
            throw new NotFoundException("Projet non trouvé : ID=" + pId);
        }
        Projet vProjet = new Projet(pId);
        vProjet.setNom("Projet n°" + pId);*/

        Projet vProjet = new Projet();


        DefaultTransactionDefinition vDefintion = new DefaultTransactionDefinition();
        vDefintion.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
        vDefintion.setTimeout(30); // 30 seconds

        //TransactionStatus vTransactionStatus = platformTransactionManager.getTransaction(vDefintion);

        getDaoFactory().getProjetDao().getProjet(pId);


        return vProjet;
    }


    /**
     * Renvoie la liste des {@link Projet}
     *
     * @return List
     */
    @Override
	public List<Projet> getListProjet() {
        // Je n'ai pas encore codé la DAO
        // Je mets juste un code temporaire pour commencer le cours...
        List<Projet> vList = new ArrayList<>();
        /*for (int vI = 0; vI < 9; vI++) {
            Projet vProjet = new Projet(vI);
            vProjet.setNom("Projet n°" + vI);
            vList.add(vProjet);
        }*/
        DefaultTransactionDefinition vDefintion = new DefaultTransactionDefinition();
        vDefintion.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
        vDefintion.setTimeout(30); // 30 seconds

        getDaoFactory().getProjetDao().getListProjet();
        getDaoFactory().getUtilisateurDao().getUtilisateur(Utilisateur pId)

        return vList;
    }

}
