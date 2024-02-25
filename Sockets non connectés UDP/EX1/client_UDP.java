package udp;
import java.net.*;
import java.util.Scanner;

public class client_UDP {
    public static void main(String argv[]) {
        int port = 0;
        String host = "";
        Scanner keyb = new Scanner(System.in);

        try {
            // Récupération des paramètres : nom de la machine serveur et numéro de port
            System.out.println("Adresse du serveur : ");
            host = keyb.next();
            System.out.println("Port d'écoute du serveur : ");
            port = keyb.nextInt();

            InetAddress adr;
            DatagramPacket packet;
            DatagramSocket socket;

            // adr contient l'@IP de la partie serveur
            adr = InetAddress.getByName(host);

            // Données à envoyer : chaîne de caractères
            byte[] data = (new String("Hello Word")).getBytes();

            // Création du paquet avec les données et en précisant l'adresse du serveur (@IP et port sur lequel il écoute)
            packet = new DatagramPacket(data, data.length, adr, port);

            // Création d'une socket, sans la lier à un port particulier
            socket = new DatagramSocket();

            // Envoi du paquet via la socket
            socket.send(packet);

            // Création d'un tableau vide pour la réception
            byte[] reponse = new byte[15];
            packet.setData(reponse);
            packet.setLength(reponse.length);

            // Attente du paquet envoyé sur la socket du client
            socket.receive(packet);

            // Récupération et affichage de la donnée contenue dans le paquet
            String chaine = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Reçu du serveur : " + chaine);
        } catch (Exception e) {
            System.err.println("Erreur : " + e);
        }
    }
}
