package fi.tuomax.adventofcode.year2016.day18;

import fi.tuomax.adventofcode.framework.solving.Metadata;

/**
 * <p>Solves Advent of Code 2016, day 18, part 1: 
 * Like a Rogue.
 * 
 * <p>Part 2 actually was doable without memoization or loop detection, so
 * this solver basically is the same as part 1's, and the number of iterations
 * is read from the parameters file.</p>
 *
 * @see 
 *      <a href="https://adventofcode.com/2016/day/18">
 *      Puzzle on the Advent of Code website.</a>
 */
public class LikeARogue_Part2
extends LikeARogue_Part1
{

    @Override
    protected Metadata manufactureMetadata() 
    {
        return new Metadata(
            2016, 18, 2,
            "Like a Rogue", ""
        );
    }

}

// 1998643 too low
