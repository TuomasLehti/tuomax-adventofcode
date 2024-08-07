package fi.tuomax.adventofcode.year2016.day15;

import java.util.List;

import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.solving.Solver;

/**
 * <p>Solves Advent of Code 2016, day 15, part 1: 
 * Timing is Everything.
 * @see 
 *      <a href="https://adventofcode.com/2016/day/15">
 *      Puzzle on the Advent of Code website.</a></p>
 * 
 * <p>This is a pretty straightforward puzzle. Just simulating the sculpture
 * is enough to get the answer in under a second. There is no need to check
 * every disc every time, and the last disc is only checked once, when the
 * capsule finally goes through all of the discs.</p>
 */
public class TimingIsEverything_Part1 
extends Solver
{

    @Override
    protected Metadata manufactureMetadata() 
    {
        return new Metadata(
            2016, 15, 1,
            "Timing is Everything", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input) 
    {
        return new TimingIsEverything_Parser(input);
    }

    @Override
    protected void solve() 
    {
        List<Disc> discs = ((TimingIsEverything_Parser) parser).getDiscs();
        Integer time = 0;
        while (!goesThrough(discs, time++)) {}
        setAnswer(--time);
    }

    private Boolean goesThrough(List<Disc> discs, Integer time)
    {
        for (int i = 0; i < discs.size(); i++) {
            if (discs.get(i).positionAt(time + i + 1) > 0)
                return false;
        }
        return true;
    }
    
}
