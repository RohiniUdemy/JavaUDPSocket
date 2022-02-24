package com.rohini.udpSockServer;

import java.io.IOException;
import java.net.*;

public class Main {

    public static void main(String[] args) throws IOException {
	String clientSentence;
        String modifiedSentence;
        DatagramSocket serverSocket = new DatagramSocket(4004);
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];
        System.out.println("Listening for client requests");
        while(true)
        {
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);

            clientSentence = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Message received from client " + clientSentence);
            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();
            modifiedSentence = clientSentence.toUpperCase();
            sendData = modifiedSentence.getBytes();

            DatagramPacket sendpacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
            serverSocket.send(sendpacket);
        }
    }
}
