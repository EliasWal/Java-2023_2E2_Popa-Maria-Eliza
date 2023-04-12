package com.mycompany.lab7;

/**
 *
 * @author Elias
 */
public class Exploration {
    private final SharedMemory mem = new SharedMemory();
    private final ExplorationMap map = new ExplorationMap();
    private final List<Robot> robots = new ArrayList<>();
    
    public void start(){
        for(Robot robot : robots){
            Thread robotThread = new Thread(robot);
            robotThread.start();
        }
    }
    public static void main(String args[]) {
        var explore = new Exploration();
        explore.addRobot(new Robot("Wall-E"));
        explore.addRobot(new Robot("R2D2"));
        explore.addRobot(new Robot("Optimus Prime"));
        explore.start();
    }

    public SharedMemory getMem() {
        return mem;
    }

    public ExplorationMap getMap() {
        return map;
    }

    public <any> getRobots() {
        return robots;
    }

    
}
