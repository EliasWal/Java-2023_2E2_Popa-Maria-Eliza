/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2;

/**
 *
 * @author Elias
 */


public class Road {
    private Location a;
    private Location b;
    private RoadType type;
    private int length;
    private int speedLimit;
    
    public Road(Location a, Location b, RoadType type, int length, int speedLimit){
        this.a=a;
        this.b=b;
        this.type=type;
        this.length=length;
        this.speedLimit=speedLimit;
        
    }

    public Location getA() {
        return a;
    }

    public Location getB() {
        return b;
    }

    public RoadType getType() {
        return type;
    }

    public int getLength() {
        return length;
    }

    public int getSpeedLimit() {
        return speedLimit;
    }

    public void setA(Location a) {
        this.a = a;
    }

    public void setB(Location b) {
        this.b = b;
    }

    public void setType(RoadType type) {
        this.type = type;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setSpeedLimit(int speedLimit) {
        this.speedLimit = speedLimit;
    }

    @Override
    public String toString() {
        return "Road{" + "a=" + a + ", b=" + b + ", type=" + type + ", length=" + length + ", speedLimit=" + speedLimit + '}';
    }
    
}
