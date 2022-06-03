package adsaufgabe2;

public class TestProgramm {

    public TestProgramm() {
    }

    public static void main(String[] args) {

		System.out.println("--Graph 1--");

	Graph g = new Graph(4);
	g.addEdge(0,3,6);
	g.addEdge(0,1,3);
	g.addEdge(1,2,3);
	g.addEdge(3,2,2);
	g.addEdge(1,3,2);
	boolean erfolgreich = true;
	IDijkstra t = new Dijkstra_MarcKlinge();
	if (!t.computeShortestPaths(g,0)) {
	    System.out.println("Fehler: Der Knoten 0 ist enthalten");
	    erfolgreich = false;
	}

	int abstand = t.getDistance(3);
	if (abstand != 5) {
	    System.out.println("Fehler: Knoten 3 hat nicht den Abstand " + abstand + " von Knoten 0");
	    erfolgreich = false;
	}
	int vorgaenger = t.getPredecessor(2);
	if (vorgaenger != 1) {
	    System.out.println("Fehler: Knoten 2 hat nicht den Vorgaenger " + vorgaenger);
	    erfolgreich = false;
	}
	if (erfolgreich)
	    System.out.println("Der Testfall wurde erfolgreich gemeistert.");

	t.printEverything();


		System.out.println("--Graph 2--");

		Graph b = new Graph(6);
		b.addEdge(0,1,3);
		b.addEdge(0,3,1);
		b.addEdge(0,2,8);
		b.addEdge(1,5,2);
		b.addEdge(3,1,2);
		b.addEdge(3,4,3);
		b.addEdge(4,2,3);
		b.addEdge(4,1,3);
		b.addEdge(4,0,1);
		b.addEdge(5,4,2);
		b.addEdge(5,2,1);

		IDijkstra d2 = new Dijkstra_MarcKlinge();

		d2.computeShortestPaths(b,0);

		d2.printEverything();



	}
}
