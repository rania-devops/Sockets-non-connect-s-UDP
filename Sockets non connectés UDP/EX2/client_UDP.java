package udp;
import java.net.*;
import java.util.Scanner;
import java.io.*;


public class client_UDP {
    public static void main(String argv[]) {
        int port = 9999; // port sur lequel le serveur écoute
        String host = "localhost"; // adresse du serveur
        ObjectOutputStream out = null;

        try {
            // Création d'un objet de la classe voiture
            voiture car = new voiture("fiat", "peujot");

            // Établissement de la connexion avec le serveur
            DatagramSocket clientSocket = new DatagramSocket();
            InetAddress serverAddress = InetAddress.getByName(host);

            // Sérialisation de l'objet voiture
            ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
            out = new ObjectOutputStream(new BufferedOutputStream(byteStream));
            out.writeObject(car);
            out.flush();

            // Récupération du tableau d'octets sérialisé
            byte[] serializedCar = byteStream.toByteArray();

            // Création du paquet à envoyer
            DatagramPacket packet = new DatagramPacket(serializedCar, serializedCar.length, serverAddress, port);

            // Envoi du paquet au serveur
            clientSocket.send(packet);
            System.out.println("Objet voiture envoyé au serveur.");

            // Fermeture des flux
            out.close();
            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
