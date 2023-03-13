/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab2;

/**
 *
 * @author Elias
 */
public class Lab2 {
    public static void main(String args[]){
    Location loc1 = new Location("City 1", LocationType.CITY, 0, 0);
    Location loc2 = new Location("City 2", LocationType.CITY, 10, 10);
    Location loc3 = new Location("Airport 1", LocationType.AIRPORT, 5, 5);
    Location loc4 = new Location("Gas Station 1", LocationType.GAS_STATION, 3, 3);

    Road road1 = new Road(loc1, loc2,RoadType.HIGHWAY, 20, 120);
    Road road2 = new Road(loc1, loc3,RoadType.EXPRESS,  10, 85);
    
    System.out.println(loc1);
    System.out.println(loc2);
    System.out.println(loc3);
    System.out.println(road1);
    System.out.println(road2);
    }
}