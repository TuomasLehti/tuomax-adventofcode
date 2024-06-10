package fi.tuomax.adventofcode.year2015.day04;

import fi.tuomax.adventofcode.framework.solving.Metadata;

/** 
 * <p>Solves Advent of Code 2015, day 4, part 2: 
 * The Ideal Stocking Stuffer</p>
 * 
 * <p>All the solving logic will be found from part 1.</p>
 * 
 * @see 
 *      <a href="https://adventofcode.com/2015/day/4">
 *      Puzzle on the Advent of Code website.</a>
 */

public class TheIdealStockingStuffer_Part2 
extends TheIdealStockingStuffer_Part1
{

    public static Metadata METADATA = new Metadata(        
        2015, 
        4, 
        2, 
        "The Ideal Stocking Stuffer", 
        ""
    );

    public TheIdealStockingStuffer_Part2() 
    {
        setPrefix("000000");
    }

    @Override
    protected Metadata manufactureMetadata() 
    {
        return new Metadata(        
            2015, 
            4, 
            2, 
            "The Ideal Stocking Stuffer", 
            ""
        );
    }


}
