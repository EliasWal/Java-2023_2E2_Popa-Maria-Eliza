package com.mycompany.lab4;

/**
 *
 * @author Elias
 */
public class Students implements Comparable<Students> {

    
    String name;

    public Students(String name){
        this.name=name;
    };

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }   
    
    @Override
    public int compareTo(Students other){
        return this.name.compareTo(other.getName());
    }

    @Override
    public String toString() {
        return "Students{" + "name=" + name + '}';
    }
    
    
    
    
}
