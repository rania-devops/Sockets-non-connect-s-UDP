package udp;

import java.net.*;
import java.util.Scanner;
	

	public class serveur_UDP {
	    public static void main(String argv[]) {
	        int port = 0;
	        Scanner keyb = new Scanner(System.in);

	        try {
	            // Récupération du paramètre : port d'écoute
	            System.out.println("Port d'écoute : ");
	            port = keyb.nextInt();

	            DatagramPacket packet;

	            // Création d'une socket liée au port précisé en paramètre
	            DatagramSocket socket = new DatagramSocket(port);

	            // Tableau de 15 octets qui contiendra les données reçues
	            byte[] data = new byte[15];

	            // Création d'un paquet en utilisant le tableau d'octets
	            packet = new DatagramPacket(data, data.length);

	            // Attente de la réception d'un paquet. Le paquet reçu est placé dans packet et ses données dans data.
	            socket.receive(packet);

	            // Récupération et affichage des données (une chaîne de caractères)
	            String chaine = new String(packet.getData(), 0, packet.getLength());
	            System.out.println("Reçu : " + chaine);

	            // Affichage de l'adresse IP et du port de l'émetteur
	            System.out.println("Cela vient de : " + packet.getAddress() + ":" + packet.getPort());

	            // On met une nouvelle donnée dans le paquet (qui contient donc le couple @IP/port de la socket côté client)
	            byte[] reponse = (new String("Bien reçu")).getBytes();
	            packet.setData(reponse);
	            packet.setLength(reponse.length);

	            // On envoie le paquet au client
	            socket.send(packet);
	        } catch (Exception e) {
	            System.err.println("Erreur : " + e);
	        }
	    }
	}


