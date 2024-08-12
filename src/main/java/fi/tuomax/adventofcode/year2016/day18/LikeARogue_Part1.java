package fi.tuomax.adventofcode.year2016.day18;

import java.util.List;

import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.parsing.StringParser;
import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.solving.Solver;

/**
 * <p>Solves Advent of Code 2016, day 18, part 1: 
 * Like a Rogue.
 * 
 * <p>Nothing fancy here, just simulate the thing that the puzzle asks for.
 * The trap could've been represented by a static class, but I was 
 * anticipating that part 2 needed memoization and loop detection.</p>
 *
 * @see 
 *      <a href="https://adventofcode.com/2016/day/18">
 *      Puzzle on the Advent of Code website.</a>
 */
public class LikeARogue_Part1 
extends Solver
{

    @Override
    protected Metadata manufactureMetadata() 
    {
        return new Metadata(
            2016, 18, 1,
            "Like a Rogue", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input) 
    {
        return new StringParser(input);
    }

    @Override
    protected void solve() 
    {
        int iterations = parameters.getJSONObject("part" + getMetadata().part()).getInt("iterations");
        Trap trap = new Trap(((StringParser) parser).getString());
        Long sum = 0L;
        for (int i = 0; i < iterations; i++) {
            sum += trap.countSafes();
            trap = trap.getNext();
        }
        setAnswer(sum);
    }
    
}
