
public class TravelPlanner {

    Set<Node> nodes = new HashSet<Node>();
    
    Node fin = addNode("fin");
    Node tro = addNode("tro");
    Node nrl = addNode("nrl");
    Node ntr = addNode("ntr");
    Node str = addNode("str");
    Node mor = addNode("mor");
    Node opp = addNode("opp");
    Node hed = addNode("hed");
    Node sof = addNode("sof");
    Node hor = addNode("hor");
    Node rog = addNode("rog");
    Node vsa = addNode("vsa");
    Node asa = addNode("asa");
    Node tel = addNode("tel");
    Node vsf = addNode("vsf");
    Node bus = addNode("bus");
    Node osl = addNode("osl");
    Node ake = addNode("ake");
    Node øst = addNode("øst");

    public TravelPlanner() {
        fin.addNeighbor(tro);
        tro.addNeighbor(nrl);
        nrl.addNeighbor(ntr);
        ntr.addNeighbor(str);
        str.addNeighbor(mor);
        str.addNeighbor(opp);
        str.addNeighbor(hed);
        mor.addNeighbor(sof);
        mor.addNeighbor(opp);
        hed.addNeighbor(opp);
        hed.addNeighbor(ake);
        sof.addNeighbor(opp);
        sof.addNeighbor(bus);
        sof.addNeighbor(hor);
        opp.addNeighbor(hor);
        opp.addNeighbor(bus);
        opp.addNeighbor(ake);
        opp.addNeighbor(osl);
        hor.addNeighbor(bus);
        hor.addNeighbor(tel);
        hor.addNeighbor(rog);
        bus.addNeighbor(tel);
        bus.addNeighbor(vsf);
        bus.addNeighbor(osl);
        bus.addNeighbor(ake);
        tel.addNeighbor(rog);
        tel.addNeighbor(asa);
        tel.addNeighbor(vsf);
        rog.addNeighbor(vsa);
        rog.addNeighbor(asa);
        ake.addNeighbor(øst);
        ake.addNeighbor(osl);
        asa.addNeighbor(vsa);
    }
    
    public Set getNodes() {
        return nodes;
    }
    
    public Node addNode(String name) {
        Node node = new Node(name);
        nodes.add(node);
        return node;
    }
    
    public Node getNode(String name) {
            
    }
}
