package com.mycompany.serverapp.functionalities;

/**
 *
 * @author Elias
 */
public class Game {
    //private Board board = new Board();
    private Player player1;
    private Player player2;
    private Player currentPlayer = player1;
    private Board board;

    public Game(Player player1, Player player2, int boardSize) {
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = currentPlayer;
        this.board=new Board(boardSize);
    }
    
    public void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public void makeMove(int row, int col) {
        if (board.isValidMove(row, col)) {
            board.placeSymbol(row, col, currentPlayer.getSymbol());
            switchPlayer();
        } else {
            System.out.println("Invalid move! Try again.");
        }
    }
    
    public void start(){
    }
}
