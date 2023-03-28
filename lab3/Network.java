package lab3;
import java.util.*;

public class Network {
    private  List<Node> nodes= new ArrayList<>();
    
    public void addNode(Node node){
        nodes.add(node);

    }
    public List<Node> getNodeList() {
        return nodes;
    }

    public void setNodeList(List<Node> nodes) {
        this.nodes = nodes;
    }

    //Collections.sort((nodes)network);

    @Override
    public String toString() {
        return "Network{" + "nodes=" + nodes + '}';
    }          
}
