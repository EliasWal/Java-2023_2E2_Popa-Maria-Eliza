package lab3;

/**
 *
 * @author Popa Eliza
 */
public class Person implements Node, Comparable<Person> {
    String name;
    
    @Override
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    @Override
    public int compareTo(Person other){
            return this.name.compareTo(other.name);
    }

    @Override
    public int getId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public double getWeight() {
        return Node.super.getWeight(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

}
