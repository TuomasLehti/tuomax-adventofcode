package fi.tuomax.adventofcode.year2016.day01;

import java.util.List;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Metadata;

/**
 * Solves Advent of Code 2016, day 1, part 2: 
 * No Time for a Taxicab.
 * @see 
 *      <a href="https://adventofcode.com/2016/day/1">
 *      Puzzle on the Advent of Code website.</a>
 */
public class NoTimeForATaxicab_Part2 
extends NoTimeForATaxicab_Part1
{

    @Override
    protected Metadata manufactureMetadata() 
    {
        return new Metadata(
            2016, 1, 2, 
            "No Time for a Taxicab", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input) 
    {
        return new NoTimeForATaxicab_Parser(input);
    }

    @Override
    protected Boolean finished() 
    {
        /* Finished state has been reached, if the walker has been in the same
         * coordinates twice. */
        return walker.isAtVisitedCoordinates();
    }

    
}
