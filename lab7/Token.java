package com.mycompany.lab7;

/**
 *
 * @author Elias
 */
public class Token {
    private final int number;

    public Token(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Token{" + "number=" + number + '}';
    }
    
}
