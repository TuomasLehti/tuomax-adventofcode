package fi.tuomax.adventofcode.year2016.day24;

import fi.tuomax.adventofcode.commons.Coordinates;
import fi.tuomax.adventofcode.commons.pathfinding.Graph;
import fi.tuomax.adventofcode.commons.pathfinding.MazeSolver;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>Solves Advent of Code 2016, day 24, part 1:
 * Air Duct Spelunking.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2016/day/24">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public abstract class AirDuctSpelunking
extends Solver
{

    private static Logger LOGGER = LoggerFactory.getLogger(AirDuctSpelunking.class);

    @Override
    protected Parser manufactureParser(List<String> input)
    {
        return new AirDuctSpelunking_Parser(input);
    }

    protected Graph graph = new Graph();

    @Override
    protected void solve()
    {
        Map<Integer, Coordinates> targets = ((AirDuctSpelunking_Parser) parser).getTargets();
        MazeSolver mazeSolver = new MazeSolver(((AirDuctSpelunking_Parser) parser).getMaze());

        List<Integer> nodes = new ArrayList<>(targets.keySet());
        for (int i = 0; i < nodes.size() - 1; i++) {
            for (int j = i + 1; j < nodes.size(); j++) {
                Integer len = mazeSolver.pathLength(targets.get(nodes.get(i)), targets.get(nodes.get(j)));
                graph.addNodesAndUndirectedEdge(nodes.get(i).toString(), nodes.get(j).toString(), len);
                LOGGER.debug(String.format(
                        "Distance from %d to %d is %d.", 
                        i, j, len));
            }
        }
    }

}
