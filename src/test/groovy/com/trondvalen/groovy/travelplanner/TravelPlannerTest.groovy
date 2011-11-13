package com.trondvalen.groovy.travelplanner;

import static org.junit.Assert.*

import com.trondvalen.groovy.travelplanner.NorwayCase;
import com.trondvalen.groovy.travelplanner.TravelNode;
import com.trondvalen.groovy.travelplanner.TravelPlanner;

class TravelPlannerTest extends GroovyTestCase {

    public void testNodeSetup() {
        TravelPlanner planner = new TravelPlanner(
            NorwayCase.getCase());
        
        assert true == planner.getNode("fin").neighbors("tro");        
        assert false == planner.getNode("fin").neighbors("osl");
        
        assert 19 == planner.nodes.size();
    }
    
    public void testNorway() {
        TravelPlanner planner = new TravelPlanner(
            NorwayCase.getCase());
        
        List<TravelNode> path = planner.traverse();
        
        assert 19 == path.size();
    }
    
    public void testCannotTraverseWhenMoreThanTwoNodesHaveOnlyOneNeighbor() {
        def lostCase = { planner ->
            TravelNode node1 = planner.addNode("1");
            TravelNode node2 = planner.addNode("2");
            TravelNode node3 = planner.addNode("3");
            TravelNode node4 = planner.addNode("4");
            
            node1.addNeighbor(node2);
            node2.addNeighbor(node3);
            node2.addNeighbor(node4);
        };        
        TravelPlanner planner = new TravelPlanner(lostCase);
        
        assert null == planner.traverse();        
    }
    
    public void testTraverseSimpleCase() {
        def simpleCase = { planner ->
            planner.addPath("1","2");
            planner.addPath("2","3");            
        };
        TravelPlanner planner = new TravelPlanner(simpleCase);
        
        assert planner.traverse().size() == 3;
    }
    
    public void testFallbackWhenNoVisitedNodes() {
        
    }
}