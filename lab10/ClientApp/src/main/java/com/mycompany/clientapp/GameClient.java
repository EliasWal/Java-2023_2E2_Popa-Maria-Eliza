package com.mycompany.clientapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author Elias
 */
public class GameClient {    
    private String serverAddress;
    private int PORT;
    private Socket socket;

    public GameClient(String serverAddress, int port) {
        this.serverAddress = serverAddress;
        this.PORT = port;
    }
    public void start() {
        try {
            socket = new Socket(serverAddress, PORT);
            System.out.println("Please insert one of the available options!");
            System.out.println("1.create game");
            System.out.println("2.join game");
            System.out.println("3.submit move");
            System.out.println("4.stop");
            System.out.println("5.exit");
            BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            while (true) {
                String input = consoleInput.readLine();
                if (input.equals("exit")) {
                    break;
                }
                out.println(input);

                // Read the server's response until the "END" delimiter is reached
                StringBuilder responseBuilder = new StringBuilder();
                String line;
                while ((line = in.readLine()) != null && !line.equals("END")) {
                    responseBuilder.append(line);
                    responseBuilder.append("\n");
                }
                String response = responseBuilder.toString().trim();
                System.out.println("Server response:\n" + response);
            }
        } catch (IOException e) {
            System.err.println("Error connecting to server: " + e.getMessage());
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.err.println("Error closing socket: " + e.getMessage());
            }
        }
    }
}
