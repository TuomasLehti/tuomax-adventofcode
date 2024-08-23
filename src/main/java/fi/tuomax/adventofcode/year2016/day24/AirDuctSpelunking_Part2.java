package fi.tuomax.adventofcode.year2016.day24;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.commons.pathfinding.TravellingSalesman;

/**
 * <p>Solves Advent of Code 2016, day 24, part 2:
 * Air Duct Spelunking.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2016/day/24">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class AirDuctSpelunking_Part2
extends AirDuctSpelunking
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2016, 24, 2,
            "Air Duct Spelunking", ""
        );
    }

    @Override
    protected void solve()
    {
        super.solve();
        TravellingSalesman.fixedStartingNode = "0";
        TravellingSalesman.returnToStartingNode = true;
        setAnswer(TravellingSalesman.minDistance(graph));
    }

}
