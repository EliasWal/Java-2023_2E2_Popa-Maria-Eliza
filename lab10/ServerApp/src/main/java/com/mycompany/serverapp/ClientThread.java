
package com.mycompany.serverapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Elias
 */
public class ClientThread extends Thread{
    private Socket socket;
    
    public ClientThread (Socket socket) {
        this.socket = socket ; 
    }
    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
            while (true) {
                String input = in.readLine();
                if (input == null) {
                    break;
                }
                if(input.equals("stop")){
                    System.out.println("Server stopped");
                    out.println("Server stopped");
                    break;
                }
                System.out.println("Server received message: " + input);
                out.println("Server received message: " + input);
            }

        } catch (IOException e) {
            System.err.println("Error handling client: " + e.getMessage());
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.err.println("Error closing client socket: " + e.getMessage());
            }
        }
    }
}
