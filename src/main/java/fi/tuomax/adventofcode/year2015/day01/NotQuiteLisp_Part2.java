package fi.tuomax.adventofcode.year2015.day01;

import java.util.List;

import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.parsing.StringParser;
import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.solving.Solver;

/**
 * Solves Advent of Code 2015, day 1, part 2: 
 * Not Quite Lisp.
 * @see 
 *      <a href="https://adventofcode.com/2015/day/1">
 *      Puzzle on the Advent of Code website.</a>
 */
public class NotQuiteLisp_Part2 
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
     * Part 2 uses the same brute force solution than part 1, but the loop is 
     * cut short when Santa enters the basement for the first time.
     */
    @Override
    protected void solve() 
    {
        Integer floor = 0;
        Integer index = 1; // Santa's insturction's indexes are 1-based.
        for (char c : getParser().getString().toCharArray()) {
            if (c == '(')
                floor++;
            else
                floor--;
            if (floor.equals(-1))
                break;
            index++;
        }
        setAnswer(index);
    }

    @Override
    protected Metadata manufactureMetadata() {
        return new Metadata(
            2015, 1, 2, 
            "Not Quite Lisp", 
            "");
    }
    
}
