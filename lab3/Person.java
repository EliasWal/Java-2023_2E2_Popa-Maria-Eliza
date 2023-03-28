package lab3;

import java.util.*;

public class Person implements Node, Comparable<Person> {
    private String name;
    protected String birthDate;
    protected Map<Node, String> relationships= new HashMap<>();
    protected int importance;

    public Person(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }
    
    public int getImportance() {
        return importance;
    }
    
    @Override
    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public int compareTo ( Person other )
    {
        if(!(other instanceof Person))
            return -1;
        Person p = (Person) other; 
        if ( this.importance < p.getImportance () )
            return -1 ;
        return 1 ;
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", birthDate=" + birthDate + ", relationships=" + relationships + ", importance=" + importance + '}';
    }

    public void addRelationship(Node node, String value) {
            relationships.put(node , value);
            importance++;
    }

    public Map<Node, String> getRelationships() {
        return relationships;
    }
    
}
