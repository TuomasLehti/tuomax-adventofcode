package fi.tuomax.adventofcode.year2015.day11;

import java.util.List;

import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.parsing.StringParser;
import fi.tuomax.adventofcode.framework.solving.Solver;

/**
 * Solves Advent of Code 2015, day 11: 
 * Corporate Policy.
 * @see 
 *      <a href="https://adventofcode.com/2015/day/11">
 *      Puzzle on the Advent of Code website.</a>
 */
public abstract class CorporatePolicy 
extends Solver
{

    protected Integer times = 1;

    @Override
    protected Parser manufactureParser(List<String> input) 
    {
        return new StringParser(input);
    }

    /**
     * Increments the password as many times as needed. The amount of rounds is
     * defined in the child classes.
     */
    @Override
    protected void solve() 
    {
        Password password = new Password(((StringParser) parser).getString());
        for (int i = 0; i < times; i++)
            password.incrementToNextValid();
        setAnswer(password.getPassword());
    }

    
}
