package fi.tuomax.adventofcode.year2015.day09;

import java.util.List;

import fi.tuomax.adventofcode.commons.pathfinding.TravellingSalesmanBruteforce;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.solving.Solver;

/**
 * Solves Advent of Code 2015, day 9, part 1: 
 * All in a Single Night.
 * @see 
 *      <a href="https://adventofcode.com/2015/day/9">
 *      Puzzle on the Advent of Code website.</a>
 */
public class AllInASingleNight_Part1 
extends Solver
{

    @Override
    protected Metadata manufactureMetadata() 
    {
        return new Metadata(
            2015,
            9,
            1,
            "All in a Single Night",
            ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input) 
    {
        return new AllInASingleNight_Parser(input);
    }

    @Override
    protected void solve() 
    {
        setAnswer(
            TravellingSalesmanBruteforce.minDistance(
                ((AllInASingleNight_Parser) parser).getGraph()
            )
        );
    }
    
}
