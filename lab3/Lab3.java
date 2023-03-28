package lab3;
import java.util.*;

public class Lab3 {

    
    public static void main(String[] args) {
        //Cumpulsory
        List<Node> list = new ArrayList();
        
        list.add(new Programmer("Alice","23/01/1998", "font-end", "HTML"));
        list.add(new Company("Amazon", 1990, 102));
        list.add(new Programmer("Andy","08/12/1995", "font-end", "HTML"));
        
        for (Node node : list) {
            System.out.println(node.getName());
        }
        
        //Homework
        //Create the persons and company
        Person n1 = new Programmer("Marcel","11/02/2000","front-end","HTML");
        Person n2 = new Programmer("Vlad","29/10/2002","back-end","PHP");
        Person n3 = new Designer("Alex","07/04/1998","graphic","Photoshop");
        Person n4 = new Designer("Andrei","17/02/1996","interface","Sketch");
        Person n5 = new Designer("Ciprian","07/09/2003","product","CAD");
        Company n6 = new Company("Endava", 2000, 200);
        
        //add relationships to the persons and companies
        n1.addRelationship(n2, "manager");
        n1.addRelationship(n3, "manager");
        n3.addRelationship(n4, "manager");
        n4.addRelationship(n5,"colleague");
        n3.addRelationship(n5, "manager");
        n1.addRelationship(n6,"CEO");
        n2.addRelationship(n6, "employee");
        n3.addRelationship(n6, "employee");
        n4.addRelationship(n6, "employee");
        //get importance method call
        System.out.println(n1.getImportance());
        System.out.println(n2.getImportance());
        System.out.println(n3.getImportance());
        System.out.println(n4.getImportance());
        System.out.println(n5.getImportance()); 

        System.out.println();
        
        //Create the network 
        Network  network = new Network();
        //add nodes to the network
        network.addNode(n1);
        network.addNode(n2);
        network.addNode(n3);
        network.addNode(n4);
        network.addNode(n5);
        network.addNode(n6); 
        
        
        System.out.println( n1.getName() + n1.getRelationships());
        System.out.println( n2.getName() + n2.getRelationships());
        System.out.println( n3.getName() + n3.getRelationships());
        System.out.println( n4.getName() + n4.getRelationships());
        System.out.println( n5.getName() + n5.getRelationships());
        
        //print to the screen the list of nodes in the network
        for (Node node : network.getNodeList()) {
        System.out.println(node.getName());
        }
        
        
        
    }

}
