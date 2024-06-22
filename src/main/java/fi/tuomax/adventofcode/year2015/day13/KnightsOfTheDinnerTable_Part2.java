package fi.tuomax.adventofcode.year2015.day13;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import fi.tuomax.adventofcode.commons.pathfinding.Graph;
import fi.tuomax.adventofcode.commons.pathfinding.TravellingSalesman_ReturnsToStartingNode;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.solving.Solver;

/**
 * Solves Advent of Code 2015, day 13, part 2:
 * Knights of the Dinner Table
 * @see 
 *      <a href="https://adventofcode.com/2015/day/13">
 *      Puzzle on the Advent of Code website.</a>
 */
public class KnightsOfTheDinnerTable_Part2 
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2015, 13, 2,
            "Knights of the Dinner Table", "");
    }

    @Override
    protected Parser manufactureParser(List<String> input)
    {
        return new KnighsOfTheDinnerTable_Parser(input);
    }

    @Override
    protected void solve()
    {
        Graph graph = ((KnighsOfTheDinnerTable_Parser) parser).getGraph();
        Set<String> nodeNames = new HashSet<String>(graph.nodes());
        for (String nodeName : nodeNames) {
            graph.addNodesAndUndirectedEdge(nodeName, "Me", 0);
        }
        setAnswer(TravellingSalesman_ReturnsToStartingNode.maxDistance(graph));
    }


    
}
