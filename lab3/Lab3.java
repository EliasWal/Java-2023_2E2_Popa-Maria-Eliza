package lab3;
import java.util.*;
import lab3.Node;
/**
 *
 * @author Popa Eliza
 */
public class Lab3 {

    
    public static void main(String[] args) {
        Person p1=new Person();
        p1.name="Alex";

        Company c1=new Company();
        c1.name="Conti";
        
        
        List<Node> nodeList = new ArrayList<>();
        nodeList.add(p1);
        nodeList.add(c1);
        
        
        for ( Node node: nodeList){
            System.out.println(node.getName());
        }
    }
    
}
