package fi.tuomax.adventofcode.year2015.day12;

import fi.tuomax.adventofcode.framework.solving.Metadata;

/**
 * Solves Advent of Code 2015, day 12, part 1:
 * JSAbacusFramework.io.
 * @see 
 *      <a href="https://adventofcode.com/2015/day/12">
 *      Puzzle on the Advent of Code website.</a>
 */
public class JSAbacusFrameworkIo_Part1 
extends JSAbacusFrameworkIo
{

    @Override
    protected Metadata manufactureMetadata() 
    {
        return new Metadata(
            2015, 12, 1,
            "JSAbacusFramework.io", ""
        );
    }

    @Override
    public Boolean abort(Object o) 
    {
        return false;
    }
    
}
