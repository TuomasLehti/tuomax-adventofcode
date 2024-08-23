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
 * <p>Guaranteed to work with complete graphs only. (A complete graph is a 
 * graph, where every distinct pair of nodes is connected with a pair of unique 
 * edges (one in each direction).)</p>
 * 
 * <p>The default behaviour is that every node is visited exactly once, and the 
 * starting and ending nodes have not been defined. This behaviour can be 
 * changed via the settings.</p>
 */
public class TravellingSalesman {

    /**
     * The node from which the traversal begins. If it is empty, the search
     * tries traversals starting from every node.
     */
    public static String fixedStartingNode = "";

    /**
     * Should the traversal return to the start node?
     */
    public static Boolean returnToStartingNode = false;

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
        List<List<String>> permutations = 
            Permutator.getPermutations(new ArrayList<String>(graph.nodes()));

        if (!fixedStartingNode.equals(""))
            permutations = removeWrongStartingNodes(permutations);

        if (returnToStartingNode)
            permutations = addReturnEdges(permutations);

        return permutations;
    }

    /**
     * Adds returning edges from the last node to the starting node.
     */
    private static List<List<String>> addReturnEdges(List<List<String>> permutations) 
    {
        for (List<String> permutation : permutations)
            permutation.add(permutation.get(0));
        return permutations;
    }

    /**
     * Removes routes which have a wrong starting node. The sizes of graphs in
     * Advent of Code puzzles are quite small, and doing the unnecessary work
     * of first adding all routes and then removing some of them doesn't become
     * a factor.
     */
    private static List<List<String>> removeWrongStartingNodes(List<List<String>> permutations) 
    {
        List<List<String>> result = new ArrayList<>();
        for (List<String> permutation : permutations)
            if (permutation.get(0).equals(fixedStartingNode))
                result.add(permutation);
        return result;
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
