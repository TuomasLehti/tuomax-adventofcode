package fi.tuomax.adventofcode.year2016.day13;

import java.util.List;

import fi.tuomax.adventofcode.commons.Coordinates;
import fi.tuomax.adventofcode.commons.Dfs;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.parsing.StringParser;
import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.solving.Solver;

public class AMazeOfTwistyLittleCubicles_Part2
extends Solver
{

    @Override
    protected Metadata manufactureMetadata() 
    {
        return new Metadata(
            2016, 13, 2,
            "A Maze of Twisty Little Cubicles", ""
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
        MazeGenerator.favoriteNumber = Integer.valueOf(((StringParser) parser).getString());
        Integer targetX = parameters.getJSONObject("part1").getInt("target_x");
        Integer targetY = parameters.getJSONObject("part1").getInt("target_y");
        CubicleDfsState.target = new Coordinates((long) targetX, (long) targetY);
        CubicleFdsState_Part2.targetSteps = parameters.getJSONObject("part2").getInt("target_steps") + 1;
        Dfs dfs = new Dfs();
        dfs.search(new CubicleFdsState_Part2()); // discard result
        setAnswer(dfs.getQueue().size());
    }
    
}
