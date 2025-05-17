package fi.tuomax.adventofcode.year2017.day17;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.parsing.StringParser;
import fi.tuomax.adventofcode.framework.solving.Solver;

import java.util.List;

/**
 * <p>Solves Advent of Code 2017, day 17, part 1:
 * Spinlock.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2017/day/17">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class Spinlock_Part1
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2017, 17, 1,
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

        Spinlock head = new Spinlock();
        Spinlock current = head;

        int value = 1;
        for (int step = 0; step < 2017; step++) {
            current = current.add(steps, value);
            value++;
        }
        setAnswer(current.getNext().getValue());
    }

}
