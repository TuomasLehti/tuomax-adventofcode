package fi.tuomax.adventofcode.year2016.day04;

import java.util.List;

import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.solving.Solver;

/**
 * Solves Advent of Code 2016, day 4, part 1: 
 * Security Through Obscurity.
 * @see 
 *      <a href="https://adventofcode.com/2016/day/4">
 *      Puzzle on the Advent of Code website.</a>
 */
public class SecurityThroughObscurity_Part1 
extends Solver
{

    @Override
    protected Metadata manufactureMetadata() 
    {
        return new Metadata(
            2016, 4, 1, 
            "Security Through Obscurity", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input) 
    {
        return new RoomParser(input);
    }

    @Override
    protected void solve() 
    {
        Integer sum = 0;
        for (Room room : (RoomParser) parser)
            if (room.isReal())
                sum += room.getSectorId();
        setAnswer(sum);
    }
    
}