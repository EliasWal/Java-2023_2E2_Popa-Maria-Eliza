package com.mycompany.lab4;

/**
 *
 * @author Elias
 */
public class Projects implements Comparable<Projects>{
    String name;

    public Projects(String name) {
        this.name=name;
    }
    
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public int compareTo(Projects other){
        return this.name.compareTo(other.getName());
    }

    @Override
    public String toString() {
        return "Projects{" + "name=" + name + '}';
    }
    

}
