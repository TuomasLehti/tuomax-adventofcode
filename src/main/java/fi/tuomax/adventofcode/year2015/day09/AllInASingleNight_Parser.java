package fi.tuomax.adventofcode.year2015.day09;

import java.util.List;

import fi.tuomax.adventofcode.commons.pathfinding.Graph;
import fi.tuomax.adventofcode.framework.parsing.Parser;

/**
 * Parses input for Advent of Code 2015, day 9.
 */
public class AllInASingleNight_Parser 
extends Parser
{

    public AllInASingleNight_Parser(List<String> input) {
        super(input);
    }

    private Graph graph = new Graph();

    @Override
    public void parse() {
        /* The input is of form "[FROM] to [TO] = [DISTANCE]" */
        for (String line : input) {
            String[] parts = line.trim().split(" ");
            graph.addNodesAndUndirectedEdge(
                parts[0], 
                parts[2], 
                Integer.valueOf(parts[4])
            );
        }
    }

    public Graph getGraph() {
        return graph;
    }
    
}
