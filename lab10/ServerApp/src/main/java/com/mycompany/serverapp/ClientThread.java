
package com.mycompany.serverapp;

import com.mycompany.serverapp.functionalities.Board;
import com.mycompany.serverapp.functionalities.Game;
import com.mycompany.serverapp.functionalities.Player;
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
        boolean isRunning = true;
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
            while (isRunning) {
                String input = in.readLine();
                if (input == null) {
                    break;
                }
                if(input.equals("stop")){
                    System.out.println("Server stopped");
                    out.println("Server stopped");
                    isRunning=false;
                    socket.close();
                    break;
                }
                else
                if(input.equals("create game")){
                    //Game game= new Game();
                    System.out.println("Server received message: " + input);
                    System.out.println("Game created succesfully!");
                    out.println("Game created succesfully!");
                    Board board=new Board(15);
                    board.printBoard();
                    String boardString = getBoardString(board);
                    out.println(boardString);
                    Player player1 = new Player("P1", 'X');
                    Player player2 = new Player("P2", 'O');
                    Game game = new Game(player1, player2, 15);
                }
                else
                if(input.equals("join game")){
                    System.out.println("Server received message: " + input);
                    System.out.println("Player entered the game succesfully!");
                    out.println("Player entered the game succesfully!");
                     
                    
                }
                if(input.equals("submit move")){
                    System.out.println("Server received message: " + input);
                    System.out.println("Player submitted move succesfully!");
                    out.println("Server received message: " + input);
                    out.println("Player submitted move succesfully!");
                }
                
                {
                System.out.println("Server received message: " + input);
                System.out.println("Please insert one of the available options!");
                System.out.println("1.create game");
                System.out.println("2.join game");
                System.out.println("3.submit move");
                System.out.println("4.stop");
                System.out.println("5.exit");

                System.out.println("Please insert one of the available options!");
                System.out.println("1.create game");
                System.out.println("2.join game");
                System.out.println("3.submit move");
                System.out.println("4.stop");
                System.out.println("5.exit");
                out.println("END");
                out.flush();

                }
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
    private String getBoardString(Board board) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                sb.append(board.getGrid()[i][j]);
                if (j != board.getSize() - 1) {
                    sb.append(" | ");
                }
            }
            sb.append("\n");
            if (i != board.getSize() - 1) {
                sb.append("--------------------------------------------------------\n");
            }
        }
        return sb.toString();
    }

}
