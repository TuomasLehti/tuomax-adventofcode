package fi.tuomax.adventofcode.year2017.day06;

import fi.tuomax.adventofcode.framework.solving.Metadata;

/**
 * <p>Solves Advent of Code 2017, day 6, part 2:
 * Memory Reallocation.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2017/day/6">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class MemoryReallocation_Part2
extends MemoryReallocation_Part1
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2017, 6, 2,
            "Memory Reallocation", ""
        );
    }

    @Override
    protected void solve()
    {
        super.solve();
        setAnswer(cycle - memo.indexOf(currentStateOfBanks));
    }

}
