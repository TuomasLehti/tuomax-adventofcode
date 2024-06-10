package fi.tuomax.adventofcode.year2015.day03;

import java.util.List;
import java.util.Set;

import fi.tuomax.adventofcode.commons.Coordinates;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.parsing.StringParser;
import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.solving.Solver;

/**
 * Solves Advent of Code 2015, day 3, part 2: 
 * Perfectly Spherical Houses in a Vacuum
 * @see 
 *      <a href="https://adventofcode.com/2015/day/3">
 *      Puzzle on the Advent of Code website.</a>
 */
public class PerfectlySphericalHousesInAVacuum_Part2 
extends Solver
{

    /** 
     * There are two Santas in part 2. They both get their own Walker, which
     * is onlý called either on even or odd steps.
     */
    @Override
    protected void solve() {
        Walker[] santas = new Walker[]{
            new Walker(),
            new Walker()
        };
        Integer step = 0;
        for (char c : ((StringParser) this.parser).getString().toCharArray()) {
            santas[step % 2].walk(c);
            step++;
        }
        Set<Coordinates> allVisited = santas[0].getVisited();
        allVisited.addAll(santas[1].getVisited());
        setAnswer(allVisited.size());
    }

    @Override
    protected Metadata manufactureMetadata() 
    {
        return new Metadata(
            2015, 
            3, 
            2, 
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
