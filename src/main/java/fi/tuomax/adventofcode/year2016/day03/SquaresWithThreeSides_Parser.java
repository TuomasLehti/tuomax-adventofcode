package fi.tuomax.adventofcode.year2016.day03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fi.tuomax.adventofcode.framework.parsing.Parser;

/**
 * <p>Parses input for Advent of Code 2016, day 3: 
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
public abstract class SquaresWithThreeSides_Parser 
extends Parser
implements Iterable<Triangle>
{

    private List<Triangle> triangles = new ArrayList<>();

    protected void addTriangle(Triangle triangle)
    {
        triangles.add(triangle);
    }

    public SquaresWithThreeSides_Parser(List<String> input) 
    {
        super(input);
    }

    @Override
    public Iterator<Triangle> iterator() {
        return triangles.iterator();
    }

    
}
