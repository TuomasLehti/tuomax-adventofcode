package fi.tuomax.adventofcode.year2016.day24;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.commons.Coordinates;
import fi.tuomax.adventofcode.commons.pathfinding.Graph;
import fi.tuomax.adventofcode.commons.pathfinding.MazeSolver;
import fi.tuomax.adventofcode.commons.pathfinding.TravellingSalesman;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>Solves Advent of Code 2016, day 24, part 1:
 * Air Duct Spelunking.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2016/day/24">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class AirDuctSpelunking_Part1
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2016, 24, 1,
            "Air Duct Spelunking", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input)
    {
        return new AirDuctSpelunking_Parser(input);
    }

    @Override
    protected void solve()
    {
        Map<Integer, Coordinates> targets = ((AirDuctSpelunking_Parser) parser).getTargets();
        MazeSolver mazeSolver = new MazeSolver(((AirDuctSpelunking_Parser) parser).getMaze());
        Graph graph = new Graph();

        List<Integer> nodes = new ArrayList<>(targets.keySet());
        for (int i = 0; i < nodes.size() - 1; i++) {
            for (int j = i + 1; j < nodes.size(); j++) {
                Integer len = mazeSolver.pathLength(targets.get(nodes.get(i)), targets.get(nodes.get(j)));
                System.out.println(String.format("%d -> %d : %d", i, j, len));
                graph.addNodesAndUndirectedEdge(nodes.get(i).toString(), nodes.get(j).toString(), len);
            }
        }

        TravellingSalesman.fixedStartingNode = "0";
        setAnswer(TravellingSalesman.minDistance(graph));
    }

}
