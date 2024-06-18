package fi.tuomax.adventofcode.commons.pathfinding;

import java.util.HashMap;
import java.util.Set;

/**
 * A data structure to repesent a graph.
 * @see https://en.wikipedia.org/wiki/Graph_(discrete_mathematics)
 */
public class Graph {

    private HashMap<String, Node> graph = new HashMap<>();

    public HashMap<String, Node> getGraph() {
        return graph;
    }

    /** 
     * Adds two nodes to the graph if they don't yet exist. 
     * Adds an undirected edge between the two nodes.
     */
    public void addNodesAndUndirectedEdge(String from, String to, Integer weight) 
    {
        if (!graph.containsKey(from))
            graph.put(from, new Node(from));
        if (!graph.containsKey(to))
            graph.put(to, new Node(to));
        graph.get(from).addUndirectedEdge(new Edge(graph.get(to), weight));
    }

    /** 
     * Adds two nodes to the graph if they don't yet exist. 
     * Adds a directed edge between the two nodes.
     */
    public void addNodesAndDirectedEdge(String from, String to, Integer weight) 
    {
        if (!graph.containsKey(from))
            graph.put(from, new Node(from));
        if (!graph.containsKey(to))
            graph.put(to, new Node(to));
        graph.get(from).addDirectedEdge(new Edge(graph.get(to), weight));
    }

    public Node get(String name) 
    {
        return graph.get(name);
    }

    public Set<String> nodes() 
    {
        return graph.keySet();
    }
    
}
