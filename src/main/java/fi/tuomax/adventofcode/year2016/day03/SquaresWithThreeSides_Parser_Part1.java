package fi.tuomax.adventofcode.year2016.day03;

import java.util.List;

/**
 * <p>Parses input for Advent of Code 2016, day 3, part 1: 
 * Squares With Three Sides.
 * @see 
 *      <a href="https://adventofcode.com/2016/day/3">
 *      Puzzle on the Advent of Code website.</a></p>
 * 
 * <p>This is the first case where the input is parsed differently in
 * differents parts of the puzzle, which is why ``ParseableParser`` is
 * not used in this puzzle. The parsers for different parts must have
 * a common parent, and if the part 1 parser would extend ``ParseableParser``,
 * parsing for part 2 would become cumbersome. (Or even impossible?)</p>
 */
public class SquaresWithThreeSides_Parser_Part1 
extends SquaresWithThreeSides_Parser
{

    public SquaresWithThreeSides_Parser_Part1(List<String> input) 
    {
        super(input);
    }

    @Override
    public void parse() 
    {
        for (String line : input) addTriangle(new Triangle(line));
    }
    
}
