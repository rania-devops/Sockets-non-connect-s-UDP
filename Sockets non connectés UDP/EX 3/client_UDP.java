package udp;
import java.net.*;

public class client_UDP {
    public static void main(String argv[]) {
        int port = 1250;

        try {
            // Création de la socket UDP du client
            DatagramSocket clientSocket = new DatagramSocket();
            InetAddress serverAddress = InetAddress.getByName("localhost");

            // Envoi d'un datagramme au serveur
            byte[] sendData = "Test".getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, port);
            clientSocket.send(sendPacket);

            // Réception de la réponse du serveur
            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);

            // Affichage de la réponse du serveur
            String response = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Réponse du serveur : " + response);

            // Fermeture de la socket
            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
