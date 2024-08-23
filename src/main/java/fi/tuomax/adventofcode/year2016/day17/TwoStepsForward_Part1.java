package fi.tuomax.adventofcode.year2016.day17;

import java.util.List;

import fi.tuomax.adventofcode.commons.Bfs;
import fi.tuomax.adventofcode.commons.BfsState;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.parsing.StringParser;
import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.solving.Solver;

/**
 * <p>Solves Advent of Code 2016, day 17, part 1: 
 * Two Steps Forward.
 * 
 * <p>A basic breadth first search does the trick.</p>
 *
 * @see 
 *      <a href="https://adventofcode.com/2016/day/17">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class TwoStepsForward_Part1 
extends Solver
{

    @Override
    protected Metadata manufactureMetadata() 
    {
        return new Metadata(
            2016, 17, 1,
            "Two Steps Forward", ""
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
        String passcode = ((StringParser) parser).getString();
        Bfs dfs = new Bfs();
        BfsState target = dfs.search(new StepBfsState(passcode));
        if (target != null)
            setAnswer(((StepBfsState) target).getPath());
        else
            setAnswer("error");
    }
    
}
