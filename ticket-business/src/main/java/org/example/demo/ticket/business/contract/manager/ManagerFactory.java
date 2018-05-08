package org.example.demo.ticket.business.contract.manager;

public interface ManagerFactory {

	void setTicketManager(TicketManager tTicketManager);

	void setProjetManager(ProjetManager pProjetManager);

	TicketManager getTicketManager();

	ProjetManager getProjetManager();

}
