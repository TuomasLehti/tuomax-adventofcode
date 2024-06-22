package fi.tuomax.adventofcode.year2015.day16;

import fi.tuomax.adventofcode.framework.solving.Metadata;

/**
 * Solves Advent of Code 2015, day 16, part 1:
 * Aunt Sue
 * @see 
 *      <a href="https://adventofcode.com/2015/day/16">
 *      Puzzle on the Advent of Code website.</a>
 */
public class AuntSue_Part1 
extends AuntSue_Solver
{

    @Override
    protected Boolean equalSues(Sue one, Sue other) 
    {
        for (Compound c : Compound.values()) {
            if (one.hasCompound(c) && !other.amountEqualsOrIsMissing(c, one.getAmount(c))) return false;
        }
        return true;
    }

    @Override
    protected Metadata manufactureMetadata() 
    {
        return new Metadata(
            2015, 16, 1, 
            "Aunt Sue", ""
        );
    }
    
}
