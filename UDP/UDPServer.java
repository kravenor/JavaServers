package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {
    public static void main(String[] args) throws Exception {
        DatagramSocket servSocket = new DatagramSocket(9876);
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];
        while (true) {
            DatagramPacket receivPacket = new DatagramPacket(receiveData, receiveData.length);
            servSocket.receive(receivPacket);
            String sentence = new String(receivPacket.getData());
            InetAddress IPAddress = receivPacket.getAddress();
            int port = receivPacket.getPort();
            String capitalizedSentence = sentence.toUpperCase();
            sendData = capitalizedSentence.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
            servSocket.send(sendPacket);
        }
    }
}
