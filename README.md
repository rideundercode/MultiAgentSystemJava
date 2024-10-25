Description
Ce projet met en œuvre un système multi-agent utilisant la bibliothèque JADE (Java Agent Development Framework) pour simuler un environnement de commerce où des agents acheteurs et un agent vendeur interagissent. L'application est développée en utilisant Spring Boot, ce qui permet une intégration fluide des agents dans un environnement web.

Fonctionnalités
Agents :

Agent Vendeur : Reçoit des offres des agents acheteurs et répond avec des acceptations ou des refus basés sur une logique prédéfinie.
Agents Acheteurs : Envoyent des offres au vendeur. Chaque agent acheteur peut envoyer un nombre limité d'offres et reçoit une réponse du vendeur pour chaque offre.
Interface Graphique : Le projet utilise l'interface graphique de JADE pour visualiser les agents et leurs interactions, facilitant ainsi le suivi du comportement des agents en temps réel.

Communication Asynchrone : Les agents communiquent de manière asynchrone via des messages ACL (Agent Communication Language), permettant un échange d'informations efficace et dynamique.

Technologies Utilisées
Java : Langage de programmation principal utilisé pour le développement de l'application.
Spring Boot : Framework utilisé pour construire l'application web et gérer la logique d'application.
JADE : Framework pour le développement d'agents intelligents, permettant la création et la gestion d'agents.
