package com.project.sma;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class VendeurAgent extends Agent {
    private int prixProduit = 50; // Prix fixe pour le produit

    @Override
    protected void setup() {
        System.out.println("Agent Vendeur prêt.");

        addBehaviour(new CyclicBehaviour(this) {
            @Override
            public void action() {
                ACLMessage message = receive();
                if (message != null) {
                    int offre = Integer.parseInt(message.getContent());
                    ACLMessage reponse = message.createReply();
                    if (offre >= prixProduit) {
                        reponse.setContent("Accepte");
                    } else {
                        reponse.setContent("Refuse");
                    }
                    send(reponse);
                } else {
                    block();
                }
            }
        });
    }
}
