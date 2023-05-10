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

            BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            while (true) {
                String input = consoleInput.readLine();
                if (input.equals("exit")) {
                    break;
                }
                out.println(input);
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
