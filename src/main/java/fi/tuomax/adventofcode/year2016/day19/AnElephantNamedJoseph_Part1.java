package fi.tuomax.adventofcode.year2016.day19;

import fi.tuomax.adventofcode.framework.solving.Metadata;

/**
 * <p>Solves Advent of Code 2016, day 19, part 1: 
 * An Elephant Named Joseph.
 * 
 * <p>In the first part an elf steals from it's left.</p>
 * 
 * @see 
 *      <a href="https://adventofcode.com/2016/day/19">
 *      Puzzle on the Advent of Code website.</a>
 */
public class AnElephantNamedJoseph_Part1 
extends AnElephantNamedJoseph
{
    
    @Override
    protected Metadata manufactureMetadata() 
    {
        return new Metadata(
            2016, 19, 1,
            "An Elephant Named Joseph", ""
        );
    }

    @Override
    protected Elf stealFrom(Elf inTurn) 
    {
        return inTurn.left;
    }
    
}
