package fi.tuomax.adventofcode.commons.pathfinding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>A very naive and crude brute-force solution for the travelling 
 * salesman problem.</p>
 * 
 * <p>The start and end node is the same. Visits every other node exactly 
 * once, and the starting and ending nodes 
 * have not been defined. Guaranteed to work with complete graphs only.
 * (A complete graph is a graph, where every distinct pair of nodes is
 * connected with a pair of unique edges (one in each direction).)</p>
 */
public class TravellingSalesman_ReturnsToStartingNode {

    /**
     * Counts the minimum distance (weight) for complete traversal of
     * the graph.
     */
    public static Integer minDistance(Graph graph) {
        List<Integer> distances = distances(graph);
        return distances.get(0);
    }

    /**
     * Counts the maximum distance (weight) for complete traversal of
     * the graph.
     */
    public static Integer maxDistance(Graph graph) {
        List<Integer> distances = distances(graph);
        return distances.get(distances.size() - 1);
    }

    /**
     * Collects all possible routes through the graph. In other words, collects
     * all possible permutations of the nodes of the graph.
     */
    private static List<List<String>> routes(Graph graph)
    {
        List<List<String>> routes = Permutator.getPermutations(new ArrayList<String>(graph.nodes()));
        for (List<String> route : routes) 
            route.add(route.get(0));
        return routes;
    }

    /** 
     * Counts the distances (weights) for a set of routes (traversals) theough
     * the graph. The corresponding route is also returned.
     */
    private static Map<Integer, List<String>> routeDistances(List<List<String>> routes, Graph graph)
    {
        Map<Integer, List<String>> distances = new HashMap<>();
        for (List<String> route : routes) {
            Integer distance = 0;
            for (int idx = 0; idx < route.size()-1; idx++) {
                String currentName = route.get(idx);
                String nextName = route.get(idx + 1);
                distance += graph.get(currentName).getEdge(nextName).weight();
                distance += graph.get(nextName).getEdge(currentName).weight();
            }
            distances.put(distance, route);
        }
        return distances;
    }
    
    /** 
     * Counts the distances (weights) for a set of routes (traversals) theough
     * the graph.
     */
    private static List<Integer> distances(Graph graph) 
    {
        List<List<String>> routes = routes(graph);
        Map<Integer, List<String>> distances = routeDistances(routes, graph);
        List<Integer> dists = new ArrayList<Integer>(distances.keySet());
        Collections.sort(dists);
        return dists;
    }

}
