package udp;
import java.util.Scanner;
import java.io.*;
import java.net.*;
import java.util.Date;

public class serveur_UDP {
    public static void main(String[] args) {
        int port = 1250;

        try {
            // Création de la socket UDP du serveur
            DatagramSocket serverSocket = new DatagramSocket(port);

            System.out.println("Serveur UDP en attente sur le port " + port);

            while (true) {
                // Création d'un tableau d'octets pour recevoir les données
                byte[] receivedData = new byte[1024];

                // Création du paquet à recevoir
                DatagramPacket receivedPacket = new DatagramPacket(receivedData, receivedData.length);

                // Attente de la réception du paquet
                serverSocket.receive(receivedPacket);

                // Récupération de l'adresse IP et du port de l'émetteur
                InetAddress clientAddress = receivedPacket.getAddress();
                int clientPort = receivedPacket.getPort();

                // Récupération de la date et l'heure actuelle
                String dateTime = new Date().toString();

                // Conversion de la date en tableau d'octets
                byte[] responseData = dateTime.getBytes();

                // Création du paquet à envoyer
                DatagramPacket responsePacket = new DatagramPacket(responseData, responseData.length, clientAddress, clientPort);

                // Envoi de la réponse au client
                serverSocket.send(responsePacket);

                System.out.println("Réponse envoyée à l'adresse " + clientAddress + ":" + clientPort);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
