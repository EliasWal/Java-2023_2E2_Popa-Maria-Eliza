package com.mycompany.clientapp;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Elias
 */
public class ClientApp {

    public static void main(String[] args) {
       
        GameClient client = new GameClient("127.0.0.1", 8100);
        client.start();
        
    }
}
