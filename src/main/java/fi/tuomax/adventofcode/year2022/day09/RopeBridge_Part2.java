package fi.tuomax.adventofcode.year2022.day09;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;
import java.util.List;

/**
 * <p>Solves Advent of Code 2022, day 9, part 2:
 * Rope Bridge.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2022/day/9">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class RopeBridge_Part2
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2022, 9, 2,
            "Rope Bridge", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input)
    {
        return new RopeBridge_Parser(input);
    }

    @Override
    protected void solve()
    {
    }

}
