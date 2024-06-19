package fi.tuomax.adventofcode.year2015.day11;

import fi.tuomax.adventofcode.framework.solving.Metadata;

/**
 * Solves Advent of Code 2015, day 11, part 2: 
 * Corporate Policy.
 * @see 
 *      <a href="https://adventofcode.com/2015/day/9">
 *      Puzzle on the Advent of Code website.</a>
 */
public class CorporatePolicy_Part2
extends CorporatePolicy
{

    public CorporatePolicy_Part2()
    {
        times = 2;
    }

    @Override
    protected Metadata manufactureMetadata() 
    {
        return new Metadata(
            2015, 11, 2,
            "Corporate Policy", "");
    }

}
