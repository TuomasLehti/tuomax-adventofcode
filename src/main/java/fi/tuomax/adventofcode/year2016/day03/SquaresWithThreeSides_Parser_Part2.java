package fi.tuomax.adventofcode.year2016.day03;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Parses input for Advent of Code 2016, day 3, part 2: 
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

public class SquaresWithThreeSides_Parser_Part2 
extends SquaresWithThreeSides_Parser
{

    public SquaresWithThreeSides_Parser_Part2(List<String> input) 
    {
        super(input);
    }

    @Override
    public void parse() 
    {
        List<Integer[]> numbers = new ArrayList<>();
        for (String line : input) {
            String[] parts = line.replaceAll(" +", " ")
                                 .replaceAll("^ ", "")
                                 .split(" ");
            Integer[] sides = new Integer[3];
            sides[0] = Integer.valueOf(parts[0]);
            sides[1] = Integer.valueOf(parts[1]);
            sides[2] = Integer.valueOf(parts[2]);
            numbers.add(sides);
        }

        for (int idx = 0; idx < numbers.size(); idx += 3) {
            addTriangle(new Triangle(
                numbers.get(idx)[0], numbers.get(idx+1)[0], numbers.get(idx+2)[0]));
            addTriangle(new Triangle(
                numbers.get(idx)[1], numbers.get(idx+1)[1], numbers.get(idx+2)[1]));
            addTriangle(new Triangle(
                numbers.get(idx)[2], numbers.get(idx+1)[2], numbers.get(idx+2)[2]));
        }
    }
    
}
