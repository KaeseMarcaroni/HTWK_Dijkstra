package adsaufgabe2;

/**
 * Klassen, die dieses Interface implementieren, enthalten eine
 * Implementation des Dijkstra-Algorithmus fuer die kuerzesten Wege.
 * 
 * Zur Verwendung:
 * 1. Durch Aufruf der Methode computeShortestPaths wird der Algorithmus
 *    durchgefuehrt und seine Ergebnisse innerhalb der Klasse gespeichert
 * 2. Fuer die einzelnen Knoten kann anschliessend der Vorgaenger und
 *    der Abstand zum Startknoten abgefragt werden
 *
 * Es koennen nacheinander mehrfach die Schritte (1) und (2) ausgefuehrt
 * werden und es ist auch die gleichzeitige Durchfuehrung in mehreren
 * Objekten der Klasse moeglich.
 */

public interface IDijkstra {

    /**
     * Der Dijkstra-Algorithmus wird durchgefuehrt.
     * Wie in der Vorlesung wird bei mehreren Knoten mit dem gleichen 
     * minimalen Abstandswert derjenige Knoten ausgewaehlt, der den 
     * kleineren Index (Nummer des Knotens) besitzt.
     * 
     * @param graph zu untersuchender Graph
     * @param sourceVertex Index des Startknotens
     * @return true gdw. der Startknoten im Graphen enthalten war
     */
    public boolean computeShortestPaths(IGraph graph, int sourceVertex);

    /**
     * Fuer einen Knoten im Graphen wird der Abstand zum Startknoten
     * aus der letzten Berechnung mit computeShortestPaths geliefert.
     *
     * @param targetVertex Nummer eines beliebigen Knotens im Graphen
     * @return Abstand bzw.  Integer.MAX_VALUE falls der Knoten nicht
     *         erreichbar ist bzw.  -1 falls der Knoten nicht existiert 
     */
    public int getDistance(int targetVertex);

    /**
     * Fuer einen Knoten im Graphen wird der Vorgaengerknoten aus dem
     * Kuerzesten-Wege-Berechnung fuer den letzten Aufruf von 
     * computeShortestPaths geliefert.
     *
     * @param targetVertex Nummer eines beliebigen Knotens im Graphen
     * @return Nummer des Vorgaengerknotens bzw. -1 falls Knoten oder
     *         Vorgaengerknoten nichts existiert
     */
    public int getPredecessor(int targetVertex);

    void printEverything();
}
