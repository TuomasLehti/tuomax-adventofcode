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
 * <p>@see part 1 for a few notes about the solution.</p>
 */
public class TimingIsEverything_Part2
extends Solver
{

    @Override
    protected Metadata manufactureMetadata() 
    {
        return new Metadata(
            2016, 15, 2,
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
        discs.add(new Disc(11, 0));
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
