package fi.tuomax.adventofcode.year2015.day12;

import fi.tuomax.adventofcode.framework.solving.Metadata;

/**
 * Solves Advent of Code 2015, day 12, part 2:
 * JSAbacusFramework.io.
 * @see 
 *      <a href="https://adventofcode.com/2015/day/12">
 *      Puzzle on the Advent of Code website.</a>
 */
public class JSAbacusFrameworkIo_Part2 
extends JSAbacusFrameworkIo
{

    @Override
    public Boolean abort(Object o) 
    {
        return (o instanceof String) && ((String) o).equals("red");
    }

    @Override
    protected Metadata manufactureMetadata() 
    {
        return new Metadata(
            2015, 12, 2,
            "JSAbacusFramework.io", ""
        );
    }
    
}
