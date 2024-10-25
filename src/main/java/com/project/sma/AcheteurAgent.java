package com.project.sma;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

import java.util.Random;

public class AcheteurAgent extends Agent {
    private int budget = 100; // Budget fixe

    private int maxOffers = 10; // Nombre maximum d'offres par agent
    private int offerCount = 0;

    @Override
    protected void setup() {
        System.out.println("Agent Acheteur prêt.");
        Random random = new Random();

        addBehaviour(new CyclicBehaviour(this) {
            @Override
            public void action() {
                if (offerCount < maxOffers) {
                    ACLMessage message = new ACLMessage(ACLMessage.PROPOSE);
                    message.addReceiver(getAID("Vendeur")); // Nom de l'agent vendeur
                    int offre = random.nextInt(budget); // Offre aléatoire
                    message.setContent(String.valueOf(offre));
                    send(message);
                    offerCount++; // Incrémenter le nombre d'offres faites

                    ACLMessage reponse = receive();
                    if (reponse != null) {
                        System.out.println("Réponse du vendeur pour l'offre de " + offre + ": " + reponse.getContent());
                    }
                    block();
                } else {
                    System.out.println("Agent Acheteur a atteint le nombre maximum d'offres.");
                    doDelete(); // Terminer l'agent après avoir atteint le maximum
                }
            }
        });
    }

}
