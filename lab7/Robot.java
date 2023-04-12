package com.mycompany.lab7;

/**
 *
 * @author Elias
 */
public class Robot implements Runnable {
    private String name;
    private boolean running;
    Exploration explore;
    private int row, col;

    public Robot(String name) {
        this.name = name;
    }
    
    public void run() {
        while (running) {
            //pick a new cell to explore
            explore.getMap().visit(row, col, this);
            //make the robot sleep for some time
        }
    }
}
