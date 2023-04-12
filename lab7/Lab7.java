package com.mycompany.lab7;

/**
 *
 * @author Elias
 */
public class Lab7 {
    Exploration explore= new Exploration();
    explore.addRobot(new Robot("a", explore));
    
    explore.start();
}
