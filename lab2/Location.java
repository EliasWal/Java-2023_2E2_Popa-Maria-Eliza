/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2;
/**
 *
 * @author Elias
 */

public class Location{
    private String name;
    private LocationType type;
    private int x;
    private int y;
    
    public Location(String name, LocationType type, int x, int y){
        this.name=name;
        this.type=type;
        this.x=x;
        this.y=y;
    }

    public String getName() {
        return name;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Location{" + "name=" + name + ", x=" + x + ", y=" + y + '}';
    }
    
}