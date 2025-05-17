package fi.tuomax.adventofcode.year2017.day17;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.parsing.StringParser;
import fi.tuomax.adventofcode.framework.solving.Solver;

import java.util.List;

/**
 * <p>Solves Advent of Code 2017, day 17, part 2:
 * Spinlock.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2017/day/17">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class Spinlock_Part2
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2017, 17, 2,
            "Spinlock", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input)
    {
        return new StringParser(input);
    }

    @Override
    protected void solve()
    {
        int steps = Integer.valueOf(((StringParser) parser).getString());

        int valueAtPos1 = 0;
        int currentPos = 0;
        for (int step = 1; step < 50_000_000; step++) {
            currentPos = (currentPos + steps) % step + 1;
            if (currentPos == 1) {
                valueAtPos1 = step;
            }
        }
        setAnswer(valueAtPos1);
    }

}
