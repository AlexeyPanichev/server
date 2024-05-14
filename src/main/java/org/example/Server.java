package org.example;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        int port = 8080;
        ServerSocket serverSocket = new ServerSocket(port);

        System.out.println("Server started on port " + port);

        try {
            Socket clientSocket = serverSocket.accept();
            System.out.println("New connection accepted");

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            final String name = in.readLine();
            out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));

            clientSocket.close();
        } catch (IOException e) {
            System.err.println("Error accepting connection: " + e.getMessage());
        } finally {
            serverSocket.close();
        }
    }
}