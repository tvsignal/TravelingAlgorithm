package com.trondvalen.groovy.travelplanner

class NorwayCase {

    public static Closure getCase() {
        def clos = { planner ->

            TravelNode fin = planner.addNode("fin");
            TravelNode tro = planner.addNode("tro");
            TravelNode nrl = planner.addNode("nrl");
            TravelNode ntr = planner.addNode("ntr");
            TravelNode str = planner.addNode("str");
            TravelNode mor = planner.addNode("mor");
            TravelNode opp = planner.addNode("opp");
            TravelNode hed = planner.addNode("hed");
            TravelNode sof = planner.addNode("sof");
            TravelNode hor = planner.addNode("hor");
            TravelNode rog = planner.addNode("rog");
            TravelNode vsa = planner.addNode("vsa");
            TravelNode asa = planner.addNode("asa");
            TravelNode tel = planner.addNode("tel");
            TravelNode vsf = planner.addNode("vsf");
            TravelNode bus = planner.addNode("bus");
            TravelNode osl = planner.addNode("osl");
            TravelNode ake = planner.addNode("ake");
            TravelNode øst = planner.addNode("øst");
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
        return clos;
    }
}
