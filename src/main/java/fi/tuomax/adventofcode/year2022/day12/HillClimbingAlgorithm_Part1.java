package fi.tuomax.adventofcode.year2022.day12;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.commons.Bfs;
import fi.tuomax.adventofcode.commons.BfsState;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;
import java.util.List;

/**
 * <p>Solves Advent of Code 2022, day 12, part 1:
 * Hill Climbing Algorithm.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2022/day/12">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class HillClimbingAlgorithm_Part1
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2022, 12, 1,
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
        Bfs bfs = new Bfs();
        BfsState target = bfs.search(new HillClimbingState(parser().getStart(), 0));
        setAnswer(target.getStep());
    }

}
