package com.mycompany.serverapp.functionalities;

/**
 *
 * @author Elias
 */
public class Board {
    private int size;
    private char[][] grid;
    
    public Board(int size){
        this.size=size;
        this.grid= new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = ' ';
            }
        }
    }
    
    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(grid[i][j]);
                if (j != size - 1) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i != size - 1) {
                System.out.println("--------------------------------------------------------");
            }
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public char[][] getGrid() {
        return grid;
    }

    public void setGrid(char[][] grid) {
        this.grid = grid;
    }

    void placeSymbol(int row, int col, char symbol) {
        if (isValidMove(row, col)) {
            grid[row][col] = symbol;
        } else {
            System.out.println("Invalid move! Try again.");
        }
    }

    boolean isValidMove(int row, int col) {
        if (row < 0 || row >= size || col < 0 || col >= size) {
            return false; // Mișcare invalidă - poziție în afara tablei
        }
        return grid[row][col] == ' '; // Verifică dacă poziția este goală
    }

    
}
