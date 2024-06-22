package fi.tuomax.adventofcode.year2015.day14;

import java.util.List;

import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.solving.Solver;

/**
 * Solves Advent of Code 2015, day 14, part 1:
 * Reindeer Olympics
 * @see 
 *      <a href="https://adventofcode.com/2015/day/14">
 *      Puzzle on the Advent of Code website.</a>
 */
public class ReindeerOlympics_Part1 
extends Solver
{

    @Override
    protected Metadata manufactureMetadata() 
    {
        return new Metadata(
            2015, 14, 1,
            "Reindeer Olympics", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input) 
    {
        return new ReindeerOlympics_Parser(input);
    }

    @Override
    protected void solve() 
    {
        Integer currentBest = Integer.MIN_VALUE;
        for (Reindeer reindeer : ((ReindeerOlympics_Parser) parser).getHerd())
            currentBest = Math.max(currentBest, reindeer.distance(2503));
        setAnswer(currentBest);
    }
    
}
