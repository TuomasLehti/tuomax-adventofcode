package fi.tuomax.adventofcode.year2015.day02;

import fi.tuomax.adventofcode.framework.solving.Metadata;

public class IWasToldThereWouldBeNoMath_Part1 
extends IWasToldThereWouldBeNoMath_Solver
{

    /**
     * Solves Advent of Code 2015, day 1, part 1: 
     * I Was Told There Would Be No Math.
     * @see 
     *      <a href="https://adventofcode.com/2015/day/2">
     *      Puzzle on the Advent of Code website.</a>
     */
    @Override
    protected Metadata manufactureMetadata() 
    {
        return new Metadata(
            2015, 2, 1, 
            "I Was Told There Would Be No Math", 
            "");
    }

    @Override
    protected Integer calculation(Present present) 
    {
        Integer frontArea = present.width() * present.height();
        Integer topArea = present.length() * present.width();
        Integer sideArea = present.length() * present.height();
        return (2 * frontArea + 2 * topArea + 2 * sideArea + 
                minimum(frontArea, topArea, sideArea));
    }
    
}
