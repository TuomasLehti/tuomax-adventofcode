package fi.tuomax.adventofcode.year2015.day13;

import java.util.List;
import fi.tuomax.adventofcode.commons.pathfinding.Graph;
import fi.tuomax.adventofcode.framework.parsing.Parser;

public class KnighsOfTheDinnerTable_Parser 
extends Parser
{

    public KnighsOfTheDinnerTable_Parser(List<String> input) {
        super(input);
    }

    private Graph graph = new Graph();

    public Graph getGraph() 
    {
        return graph;
    }

    @Override
    public void parse() {
        for (String line : input) {
            String[] tokenParts = line.split(" |\\.");
            Integer happiness = Integer.valueOf(tokenParts[3]);
            if (tokenParts[2].equals("lose"))
                happiness *= -1;
            graph.addNodesAndDirectedEdge(
                    tokenParts[0], tokenParts[10], happiness);
        }
    }
    
}
