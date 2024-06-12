package fi.tuomax.adventofcode.commons.pathfinding;

import java.util.HashSet;

/**
 * A node of a graph used for path finding.
 */
public class Node 
{

    public Node(String name) 
    {
        setName(name);
    }

    private String name = "";

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    private Boolean visited = false;

    /** 
     * Visiting a node is such a common thing in path finding algorithms,
     * that I've decided to include visitedness in the base class.
     */
    public void visit() 
    {
        visited = true;
    }

    public void unvisit()
    {
        visited = false;
    }

    public Boolean isVisited() 
    {
        return visited;
    }

    /**
     * All the edges are one-way. Two-way graphs are simulated by having two
     * different edges between two nodes.
     */
    private HashSet<Edge> edges = new HashSet<>();

    public HashSet<Edge> getEdges() 
    {
        return edges;
    }

    public Edge getEdge(String to) {
        for (Edge edge : edges) {
            if (edge.neighbor().getName().equals(to)) return edge;
        }
        return null;
    }

    /**
     * Adds a directed (one-way) edge to this node.
     */
    public void addDirectedEdge(Edge edge) 
    {
        edges.add(edge);
    }

    /**
     * Adds an undirected (two-way) edge to this node.
     */
    public void addUndirectedEdge(Edge edge)
    {
        edges.add(edge);
        edge.neighbor().addDirectedEdge(new Edge(this, edge.weight()));
    }

    private Integer tentativeDistance = Integer.MAX_VALUE;

    public Integer getTentativeDistance() {
        return tentativeDistance;
    }

    public void setTentativeDistance(Integer tentativeDistance) {
        this.tentativeDistance = tentativeDistance;
    }

    public void setTentativeDistanceToInfinity() {
        setTentativeDistance(Integer.MAX_VALUE);
    }
    
}
