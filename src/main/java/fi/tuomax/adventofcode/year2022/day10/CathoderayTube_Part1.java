package fi.tuomax.adventofcode.year2022.day10;

import fi.tuomax.adventofcode.framework.solving.Metadata;

/**
 * <p>Solves Advent of Code 2022, day 10, part 1:
 * Cathode-Ray Tube.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2022/day/10">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class CathoderayTube_Part1
extends CathoderayTube_Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2022, 10, 1,
            "Cathode-Ray Tube", ""
        );
    }

    @Override
    protected void solve()
    {
        super.solve();
        setAnswer(
            runningSum.get(19) * 20 +
            runningSum.get(59) * 60 +
            runningSum.get(99) * 100 +
            runningSum.get(139) * 140 +
            runningSum.get(179) * 180 +
            runningSum.get(219) * 220
        );


    }

}
