package fi.tuomax.adventofcode.year2017.day17;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.parsing.StringParser;
import fi.tuomax.adventofcode.framework.solving.Solver;

import java.util.ArrayList;
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

        Spinlock head = new Spinlock();
        Spinlock current = head;

        int value = 1;
        for (int step = 0; step < 50_000_000; step++) {
            if (step % 100_000 == 0) System.out.println(step);
            current = current.add(steps, value);
            value++;
        }
        setAnswer(head.getNext().getValue());
    }

}
