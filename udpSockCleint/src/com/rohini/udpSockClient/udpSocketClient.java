package com.rohini.udpSockClient;
import java.net.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class udpSocketClient {

    public static void main(String[] args) throws IOException {
	String sentence;
    String modifiedSentence;
    int port = 4004;

    InetAddress serverAddress = InetAddress.getByName("localhost");
    DatagramSocket clientSocket = new DatagramSocket();
    BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the data to send to Server");
    sentence = inFromUser.readLine();
    //byte[] sendData = new byte[1024];
    byte[] receiveData = new byte[1024];
        byte[] sendData = sentence.getBytes();
    DatagramPacket dataToSend = new DatagramPacket(sendData, sendData.length, serverAddress, port);

    clientSocket.send(dataToSend);

    DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

    clientSocket.receive(receivePacket);
    modifiedSentence = new String(receivePacket.getData(), 0, receivePacket.getLength());

        System.out.println("Response from server = " + modifiedSentence);

    }
}
