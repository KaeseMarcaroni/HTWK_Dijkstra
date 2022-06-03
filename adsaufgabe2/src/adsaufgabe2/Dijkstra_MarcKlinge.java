package adsaufgabe2;

public class Dijkstra_MarcKlinge implements IDijkstra {

    private int[] distance;
    private int[] predecessor;
    private boolean[] isDone;
    private int nextVert;

    public Dijkstra_MarcKlinge() {


	
    }

    // Bitte Spezifikation in IDijkstra beachten!
    public boolean computeShortestPaths(IGraph graph, int sourceVertex) {

        if (sourceVertex < 0 || sourceVertex > graph.getNumberVertices()-1) {
            return false;
        }
        else {
            distance = new int[graph.getNumberVertices()];
            predecessor = new int[graph.getNumberVertices()];
            isDone = new boolean[graph.getNumberVertices()];

            for (int i = 0; i < graph.getNumberVertices(); i++) {
                distance[i] = Integer.MAX_VALUE;
                predecessor[i] = -1;
                isDone[i] = false;
            }
            distance[sourceVertex] = 0;
            while (vertExists(graph)) {
                nextVert = getNextVert(graph);
                isDone[nextVert] = true;
                for (int i = 0; i < graph.getNumberVertices(); i++) {
                    if (distance[i] > distance[nextVert] + graph.getWeight(nextVert, i) && graph.getWeight(nextVert, i) != 0) {
                        distance[i] = distance[nextVert] + graph.getWeight(nextVert, i);
                        predecessor[i] = nextVert;
                    }
                }

            }
            return true;
        }
    }

    private boolean vertExists(IGraph graph) {
        for (int i = 0; i < graph.getNumberVertices(); i++) {
            if (distance[i] < Integer.MAX_VALUE && !isDone[i]) {
                return true;
            }
        }
        return false;
    }

    private int getNextVert(IGraph graph) {
        int minDistance = Integer.MAX_VALUE;
        nextVert = -1;
        for (int i = 0; i < graph.getNumberVertices(); i++) {
            if(!isDone[i] && distance[i] < minDistance) {
                minDistance = distance[i];
                nextVert = i;
            }
        }
        return nextVert;
    }

    // Bitte Spezifikation in IDijkstra beachten!
    public int getDistance(int targetVertex) {
        if (this.distance == null || targetVertex < 0 || targetVertex > distance.length -1) {
            return -1;
        }
        else {return distance[targetVertex];}
    }

    // Bitte Spezifikation in IDijkstra beachten!
    public int getPredecessor(int targetVertex) {
        if (this.predecessor == null || targetVertex < 0 || targetVertex > predecessor.length -1) {
            return -1;
        }
        else {return predecessor[targetVertex];}
    }

    public void printEverything() {
        if (this.distance == null) {
            System.out.println("kein Weg wurde berechnet");
        }
        else {
            System.out.println("--distance--");
            for (int i = 0; i < distance.length; i++) {
                System.out.println(distance[i]);
            }
            System.out.println("--predecessor--");
            for (int i = 0; i < predecessor.length; i++) {
                System.out.println(predecessor[i]);
            }
        }
    }
}
