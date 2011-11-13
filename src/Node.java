import java.util.HashSet;
import java.util.Set;


public class Node {

    private final String name;
    private final Set<Node> neighbors = new HashSet<Node>();

    Node(String name) {
        this.name = name;        
    }

    public void addNeighbor(Node neighbor) {
        neighbors.add(neighbor);
        neighbor.addNeighbor(this);        
    }
    
    @Override
    public int hashCode() {
        return name.hashCode();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Node)) return false;
        
        return name.equals(((Node) obj).name);
    }
}
