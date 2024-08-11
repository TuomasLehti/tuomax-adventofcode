package fi.tuomax.adventofcode.year2016.day17;

import java.util.List;

import fi.tuomax.adventofcode.commons.Dfs;
import fi.tuomax.adventofcode.commons.DfsState;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.parsing.StringParser;
import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.solving.Solver;

/**
 * <p>Solves Advent of Code 2016, day 17, part 2: 
 * Two Steps Forward.
 * 
 * <p>This uses a slightly modified breadth first search to find all the 
 * possible paths and then does a linear search to find the longest one.
 * It took about 76 seconds on the first try, but at the moment, I don't
 * have the motivation to try to make it any faster. I just want to move
 * to the next puzzle.</p>
 *
 * @see 
 *      <a href="https://adventofcode.com/2016/day/17">
 *      Puzzle on the Advent of Code website.</a></p>
 */

public class TwoStepsForward_Part2 
extends Solver
{

    @Override
    protected Metadata manufactureMetadata() 
    {
        return new Metadata(
            2016, 17, 2,
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
        Dfs dfs = new CompleteBfs();
        dfs.search(new StepBfsState(passcode)); // discard result
        Integer maxLength = Integer.MIN_VALUE;
        for (DfsState s : dfs.getQueue())
            if (s.isTargetState())
                maxLength = Math.max(maxLength, ((StepBfsState) s).getPath().length());
        setAnswer(maxLength);
    }
    
}
