package fi.tuomax.adventofcode.year2015.day17;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.solving.Solver;

/**
 * Solves Advent of Code 2015, day 17, part 1:
 * No Such Thing as Too Much.
 * @see 
 *      <a href="https://adventofcode.com/2015/day/16">
 *      Puzzle on the Advent of Code website.</a>
 */
public class NoSuchThingAsTooMuch_Part1 
extends Solver
{

    protected Integer amountOfLiquid = 150;

    @Override
    protected Metadata manufactureMetadata() 
    {
        return new Metadata(
            2015, 17, 1,
            "No Such Thing as Too Much", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input) 
    {
        return new NoSuchThingAsTooMuch_Parser(input);
    }

    @Override
    protected void solve() 
    {
        Set<String> solutions = ((NoSuchThingAsTooMuch_Parser) parser)
                .getContainer().fill(amountOfLiquid, new ArrayList<String>());
        setAnswer(solutions.size());
    }
    
}
