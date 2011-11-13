package com.trondvalen.groovy;

import java.util.HashSet
import java.util.Set


public class TravelNode {

    private final String name;
    private final Set<TravelNode> neighbors = new HashSet<TravelNode>();
    
    private boolean entered = false;
    private boolean visited = false;
    
    TravelNode(String name) {
        this.name = name;        
    }

    public void addNeighbor(TravelNode neighbor) {
        addNeighbor(neighbor, true);
    }
    
    private void addNeighbor(TravelNode neighbor, boolean reciprocate) {
        neighbors.add(neighbor);
        if (reciprocate)
            neighbor.addNeighbor(this, false);        
        
    }
    
    public Set<TravelNode> getNeighbors() {
        return neighbors;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof TravelNode)) return false;
        
        return name.equals(((TravelNode) obj).name);
    }
    
    public boolean neighbors(String neighbor) {
        return neighbors.find { n -> n.name.equals(neighbor) };
    }
    
    public void setEntered(boolean entered) {
        this.entered = entered;      
    }
    
    public void setVisited(boolean visited) {
        this.visited = visited;
    }
    
    public boolean isEntered() {
        return entered;
    }
    
    public boolean isVisited() {
        return visited;
    }
    
    @Override
    public String toString() {
        return name;
    }
}
