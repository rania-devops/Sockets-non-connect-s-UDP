# Sockets-non-connectés-UDP
** Rapport sur les Exercices : Programmation Réseau avec les Sockets UDP **

Objectifs du TP :
Le TP vise à illustrer la mise en œuvre du protocole de transport UDP (mode non connecté) à l'aide des sockets en Java.
Trois exercices distincts ont été abordés, chacun couvrant des aspects spécifiques de la programmation réseau avec UDP.

------------------------ Exercice 1 : Communication basique avec UDP ----------------------------

* Rappel des Principes :

     .  Mode de communication non connecté
  
     .  Chaque datagramme est transféré indépendamment
  
     .  Aucune garantie sur l'arrivée des paquets ni sur l'ordre d'arrivée
  
     .  La seule garantie est que les données reçues sont sans erreur.
* Déroulement :

- Côté Client (client_UDP) :

.Saisie de l'adresse du serveur et du port d'écoute.

.Création d'un DatagramSocket.

.Envoi d'un paquet contenant une chaîne 

.Réception d'une réponse du serveur.

.Affichage de la réponse.

- Côté Serveur (serveur_UDP) :
  
.Saisie du port d'écoute.

.Création d'un DatagramSocket lié au port spécifié.

.Attente de la réception d'un paquet.

.Affichage des données reçues.

.Envoi d'une réponse au client.

------------------------ Exercice 2 : Échange d'objets Voiture avec UDP -----------------------

Objectif :
Échange d'objets de la classe voiture entre le client et le serveur.
Déroulement :

* Côté Client (client_UDP) :

.Création d'un objet de la classe voiture.
.Sérialisation de l'objet.
.Envoi de l'objet sérialisé au serveur.

* Côté Serveur (serveur_UDP) :

.Réception de l'objet sérialisé.
.Désérialisation de l'objet.
.Manipulation de l'objet (modification de la quantité de carburant).
.Affichage des informations de l'objet.
.Envoi d'une réponse au client.

------------------------- Exercice 3 : Serveur UDP renvoyant la date et l'heure ----------------------

Objectif :
Création d'un serveur UDP répondant à chaque datagramme avec la date et l'heure actuelle.
Déroulement :

* Serveur (serveur_UDP) :
.Écoute sur le port 1250 en permanence.
.Réception d'un datagramme.
.Récupération de l'adresse de l'émetteur.
.Envoi d'un datagramme contenant la date et l'heure.
.Répétition du processus.


* Exécution et Test :
.Lancement du serveur avant le client.
