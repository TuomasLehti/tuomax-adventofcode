package fi.tuomax.adventofcode.year2016.day03;

import java.util.List;

import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Metadata;

/**
 * <p>Solves Advent of Code 2016, day 3: 
 * Squares With Three Sides.
 * @see 
 *      <a href="https://adventofcode.com/2016/day/3">
 *      Puzzle on the Advent of Code website.</a></p>
 * 
 * <p>This is the first case where the input is parsed differently in
 * differents parts of the puzzle. This solver class boils down to a factory
 * which provides the right parser for the base class.</p>
 */
public class SquaresWithThreeSides_Part2
extends SquaresWithThreeSides_Solver
{

    @Override
    protected Metadata manufactureMetadata() 
    {
        return new Metadata(
            2016, 3, 2,
            "Squares With Three Sides", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input) 
    {
        return new SquaresWithThreeSides_Parser_Part2(input);
    }

    
}
