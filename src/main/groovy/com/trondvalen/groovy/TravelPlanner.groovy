package com.trondvalen.groovy;

import org.apache.log4j.Logger

public class TravelPlanner {

    private Logger logger = Logger.getLogger(TravelPlanner.class);
    
    private Set<TravelNode> nodes = new HashSet<TravelNode>();
    
    private List<TravelNode> travelPath = new ArrayList<TravelNode>();
    
    private Set<TravelNode> visitedNodes = new HashSet<TravelNode>();

    private int visitCount = 0;
        
    public TravelPlanner(Closure travelCase) {
        travelCase(this);
    }
    
    public List<TravelNode> traverse() {
        visitCount = 0;
        Set<TravelNode> singleNeighbored = nodes.findAll { n -> n.neighbors.size() == 1 };
        
        if (singleNeighbored.size() > 2)
            return null;
        
        travelPath.clear();
        
        TravelNode startNode = null;
        if (singleNeighbored.size() > 0) {
            startNode = singleNeighbored.iterator().next();
        }
        
        visit(startNode);        
        System.out.println("Traversed nodes in " + visitCount + " visits");
        return travelPath;
    }
    
    public void visit(TravelNode node) {
        travelPath.add(0, node);
        logger.debug("Visiting " + node);        
        visitCount++;
        node.setEntered(true);
        
        Set<TravelNode> lockedNeighbors = new HashSet<TravelNode>();
        Set<TravelNode> openNodes = node.getNeighbors().findAll { n -> n.isEntered() == false };
        for (TravelNode neighbor : openNodes) {            
            visit(neighbor);            
            visitedNodes.add(neighbor);
            
            if (!neighborToAnyUnenteredNode(visitedNodes)) {
                logger.debug( "visit(" + node + "): Skipping other neighbors");
                break;
            }
            logger.debug("visit(" + node + "): It might be worth visiting other neighbors");
            for (TravelNode visited : visitedNodes) {
                visited.setEntered(false);
            }
            visitedNodes = new HashSet<TravelNode>();
        }
        
        if (travelPath.size() == nodes.size())
            return;
            
        travelPath.remove(0);
    }
    
    public boolean neighborToAnyUnenteredNode(Set<TravelNode> set) {
        Set<TravelNode> unenteredNodes = nodes.findAll { it.isEntered() == false };
        return anyNeighborNodes(set, unenteredNodes);
    }
    
    boolean anyNeighborNodes(Set<TravelNode> setA, Set<TravelNode> setB ) {
        for (TravelNode nodeA : setA) {
            Set<TravelNode> neighbors = nodeA.getNeighbors();
            for (TravelNode nodeB : setB) {
                if (neighbors.contains(nodeB))
                    return true;
            }
        }
        return false;
    }
        
    public Set getNodes() {
        return nodes;
    }
    
    public TravelNode addNode(String name) {
        TravelNode node = new TravelNode(name);
        nodes.add(node);
        return node;
    }
    
    public void addPath(String nodeA, String nodeB) {
        nodes.add(new TravelNode(nodeA));
        nodes.add(new TravelNode(nodeB));
        
        getNode(nodeA).addNeighbor(getNode(nodeB));       
    }
    
    public TravelNode getNode(String name) {
        TravelNode node = nodes.find { n -> n.name.equals (name)};
        return node;            
    }
}
