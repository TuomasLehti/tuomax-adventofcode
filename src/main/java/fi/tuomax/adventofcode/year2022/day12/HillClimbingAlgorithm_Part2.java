package fi.tuomax.adventofcode.year2022.day12;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.commons.Bfs;
import fi.tuomax.adventofcode.commons.BfsState;
import fi.tuomax.adventofcode.commons.Coordinates;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>Solves Advent of Code 2022, day 12, part 2:
 * Hill Climbing Algorithm.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2022/day/12">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class HillClimbingAlgorithm_Part2
extends Solver
{

    private Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2022, 12, 2,
            "Hill Climbing Algorithm", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input)
    {
        return new HillClimbingAlgorithm_Parser(input);
    }

    private HillClimbingAlgorithm_Parser parser()
    {
        return (HillClimbingAlgorithm_Parser) parser;
    }

    @Override
    protected void solve()
    {
        HillClimbingState.map = parser().getMap();
        HillClimbingState.target = parser().getEnd();

        Integer result = Integer.MAX_VALUE;
        for (int row = 0; row < HillClimbingState.map.height(); row++) {
            for (int col = 0; col < 2; col++) {
                if (HillClimbingState.map.get(col, row).equals(0)) {
                    LOGGER.debug("Starting from (" + col + ", " + row + ")...");
                    Bfs bfs = new Bfs();
                    BfsState target = bfs.search(new HillClimbingState(new Coordinates(0L, (long) row), 0));
                    result = Math.min(result, target.getStep());
                }
            }
        }
        setAnswer(result);
    }

}
