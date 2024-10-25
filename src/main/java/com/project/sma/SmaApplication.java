package com.project.sma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jade.core.Runtime;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;

@SpringBootApplication
public class SmaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmaApplication.class, args);
		démarrerAgents();
	}

	private static void démarrerAgents() {
		// Initialiser le runtime JADE
		Runtime rt = Runtime.instance();
		Profile profile = new ProfileImpl();
		profile.setParameter(Profile.GUI, "true");
		AgentContainer container = rt.createMainContainer(profile);

		try {
			// Créer l'agent vendeur
			AgentController vendeur = container.createNewAgent("Vendeur", VendeurAgent.class.getName(), null);
			vendeur.start();

			// Créer plusieurs agents acheteurs
			for (int i = 0; i < 5; i++) { // Par exemple, 5 acheteurs
				AgentController acheteur = container.createNewAgent("Acheteur" + i, AcheteurAgent.class.getName(), null);
				acheteur.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
