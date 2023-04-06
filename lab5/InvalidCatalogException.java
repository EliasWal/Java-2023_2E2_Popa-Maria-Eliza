package com.mycompany.lab5;

/**
 *
 * @author Elias
 */
public class InvalidCatalogException extends Exception {
    public InvalidCatalogException(Exception ex) {
        super("Invalid catalog file.", ex);
    } 
}
