package fi.tuomax.adventofcode.year2016.day05;

import java.util.List;

import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.parsing.StringParser;
import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.solving.Solver;

/**
 * Solves Advent of Code 2016, day 5, part 1: 
 * How About a Nice Game of Chess?
 * @see 
 *      <a href="https://adventofcode.com/2016/day/5">
 *      Puzzle on the Advent of Code website.</a>
 */
public class HowAboutANiceGameOfChess_Part1 
extends Solver
{

    @Override
    protected Metadata manufactureMetadata() 
    {
        return new Metadata(
            2016, 5, 1,
            "How About a Nice Game of Chess?", ""
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
        /* Another one of those MD5 finding puzzles. Generalized MD5 finder
         * from Aoc 2015 day 4 does the job. */
        String seed = ((StringParser) parser).getString();
        StringBuilder password = new StringBuilder();
        HashFinder.setSeed(seed);
        HashFinder.reset();
        for (int i = 0; i < 8; i++) {
            password.append(HashFinder.next().charAt(5));
        }
        setAnswer(password.toString());
    }
    
}
