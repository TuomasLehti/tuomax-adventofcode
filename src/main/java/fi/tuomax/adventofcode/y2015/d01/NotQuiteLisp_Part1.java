package fi.tuomax.adventofcode.y2015.d01;

import java.util.List;

import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.parsing.StringParser;
import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.solving.Solver;

/**
 * Solves Advent of Code 2015, day 1, part 1: 
 * Not Quite Lisp.
 * @see 
 *      <a href="https://adventofcode.com/2015/day/1">
 *      Puzzle on the Advent of Code website.</a>
 */
public class NotQuiteLisp_Part1 
extends Solver
{

    @Override
    protected Parser manufactureParser(List<String> input) 
    {
        return new StringParser(input);
    }

    private StringParser getParser()
    {
        return (StringParser) parser;
    }

    /** 
     * <p>Part 1 is solved with brute force, ie by counting every single 
     * character. There is no way around this.</p>
     */
    @Override
    protected void solve() 
    {
        Integer floor = 0;
        for (char c : getParser().getString().toCharArray()) {
            if (c == '(')
                floor++;
            else
                floor--;
        }
        setAnswer(floor);
    }

    @Override
    protected Metadata manufactureMetadata() {
        return new Metadata(
            2015, 1, 1, 
            "Not Quite Lisp", 
            "");
    }
    
}
