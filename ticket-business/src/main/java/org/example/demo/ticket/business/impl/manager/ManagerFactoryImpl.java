package org.example.demo.ticket.business.impl.manager;

import org.example.demo.ticket.business.contract.manager.ManagerFactory;
import org.example.demo.ticket.business.contract.manager.ProjetManager;
import org.example.demo.ticket.business.contract.manager.TicketManager;

import javax.inject.Inject;
import javax.inject.Named;

@Named("managerFactory")
public class ManagerFactoryImpl implements ManagerFactory {
	
	// Ajout d'un attribut projetManager
    @Inject
    private ProjetManager projetManager;
    @Inject
    private TicketManager ticketManager;

    // On renvoie désormais simplement l'attribut projetManager
    @Override
	public ProjetManager getProjetManager() {
        return projetManager;
    }
    @Override
	public TicketManager getTicketManager() {
        return ticketManager;
    }
    
    // Ajout d'un setter pour l'attribut projetManager
    @Override
	public void setProjetManager(ProjetManager pProjetManager) {
        projetManager = pProjetManager;
    }
    @Override
	public void setTicketManager(TicketManager tTicketManager) {
        ticketManager = tTicketManager;
    }

}
