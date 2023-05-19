package com.lab11.player;

import java.util.List;

/**
 *
 * @author Elias
 */
public class Player {
    private String nume;
    private char symbol; 
    private int id;
    private List<Player> players;

    public Player(String nume, char symbol, int id) {
        this.nume = nume;
        this.symbol=symbol;
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return "Player{" + "nume=" + nume + ", id=" + id + '}';
    }
 
   
    
}
