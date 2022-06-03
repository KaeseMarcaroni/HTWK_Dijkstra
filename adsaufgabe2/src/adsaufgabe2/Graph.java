package adsaufgabe2;

public class Graph implements IGraph {

    private boolean[][] adj;
    private int[][] gamma;
    private int size;

	//Spannt zwei Matritzen auf:
	//adj -> Matrix welche anzeigt ob Kante vorhanden ist
	//gamma -> gibt Kantengewicht zu jeder Kante an
    public Graph(int size) {
	this.size = size;
	adj = new boolean[size][];
	for (int i=0; i<size; i++)
	    adj[i] = new boolean[size];
	gamma = new int[size][];
	for (int i=0; i<size; i++)
	    gamma[i] = new int[size];
    }

    public void addEdge(int from, int to, int weight) {
	if (from>=0 && to>=0 && from<size && to<size) {
	    adj[from][to] = true;
	    gamma[from][to] = weight;
	}
    }
	
    public boolean containsEdge(int from, int to) {
	return adj[from][to];
    }

    public int getWeight(int from, int to) {
	if (adj[from][to])
	    return gamma[from][to];
	return 0;
    }
    
    public int getNumberVertices() {
	return size;
    }
}
