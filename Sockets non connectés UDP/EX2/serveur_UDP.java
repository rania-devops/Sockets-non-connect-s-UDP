package udp;

import java.net.*;
import java.util.Scanner;
import java.io.*;


public class serveur_UDP {
    public static void main(String argv[]) {
        int port = 9999; // port d'écoute du serveur

        try {
            // Création d'un tableau d'octets pour recevoir les données
            byte[] receivedData = new byte[1024];

            // Création de la socket UDP du serveur
            DatagramSocket serverSocket = new DatagramSocket(port);

            // Création du paquet à recevoir
            DatagramPacket receivedPacket = new DatagramPacket(receivedData, receivedData.length);

            // Attente de la réception du paquet
            serverSocket.receive(receivedPacket);

            // Récupération de l'objet voiture sérialisé
            ByteArrayInputStream byteStream = new ByteArrayInputStream(receivedData);
            ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(byteStream));
            voiture receivedCar = (voiture) in.readObject();

            // Manipulation de l'objet reçu
            int newCarburant = 50; // nouvelle quantité de carburant
            receivedCar.setCarburant(newCarburant);

            // Affichage des informations de l'objet reçu
            System.out.println("Objet voiture reçu du client :");
            System.out.println("Type : " + receivedCar.type);
            System.out.println("Modèle : " + receivedCar.model);
            System.out.println("Quantité de carburant après modification : " + receivedCar.getCarburant());

            // Fermeture des flux
            in.close();
            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

