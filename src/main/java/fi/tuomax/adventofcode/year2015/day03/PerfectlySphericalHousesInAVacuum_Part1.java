package fi.tuomax.adventofcode.year2015.day03;

import java.util.List;

import fi.tuomax.adventofcode.commons.Walker;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.parsing.StringParser;
import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.solving.Solver;

/**
 * Solves Advent of Code 2015, day 3, part 1: 
 * Perfectly Spherical Houses in a Vacuum
 * @see 
 *      <a href="https://adventofcode.com/2015/day/3">
 *      Puzzle on the Advent of Code website.</a>
 */
public class PerfectlySphericalHousesInAVacuum_Part1 
extends Solver
{

    /**
     * Goes through the directions and lets the Walker do all the work.
     */
    @Override
    protected void solve() 
    {
        Walker santa = new Walker();
        for (char c : ((StringParser) this.parser).getString().toCharArray()) {
            santa.walk(c);
        }
        setAnswer(santa.numOfVisited());
    }

    @Override
    protected Metadata manufactureMetadata() 
    {
        return new Metadata(
            2015, 
            3, 
            1, 
            "Perfectly Spherical Houses in a Vacuum", 
            ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input) 
    {
        return new StringParser(input);
    }
    
}
