class TravelPlannerTest extends GroovyTestCase {

    public void testFoo() {
        TravelPlanner planner = new TravelPlanner();
        
        assert true == planner.getNode("fin").neighbors("tro");
    }
}