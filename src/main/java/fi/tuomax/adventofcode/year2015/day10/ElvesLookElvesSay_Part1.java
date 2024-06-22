package fi.tuomax.adventofcode.year2015.day10;

import java.util.List;

import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.parsing.StringParser;
import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.solving.Solver;

/**
 * Solves Advent of Code 2015, day 10, part 1: 
 * Elves Look, Elves Say.
 * @see 
 *      <a href="https://adventofcode.com/2015/day/10">
 *      Puzzle on the Advent of Code website.</a>
 */
public class ElvesLookElvesSay_Part1 
extends Solver
{

    @Override
    protected Metadata manufactureMetadata() 
    {
        return new Metadata(
            2015,
            10,
            1,
            "Elves Look, Elves Say",
            ""
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
        String input = ((StringParser) parser).getString();
        for (int i = 0; i < 40; i++) {
            input = LookAndSay.lookAndSay(input);
        }
        setAnswer(input.length());
    }
    
}
