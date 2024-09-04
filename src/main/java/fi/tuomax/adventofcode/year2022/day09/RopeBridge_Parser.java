package fi.tuomax.adventofcode.year2022.day09;

import java.util.ArrayList;
import java.util.List;

import fi.tuomax.adventofcode.commons.Direction;
import fi.tuomax.adventofcode.framework.parsing.Parser;

public class RopeBridge_Parser
extends Parser
{

    private List<Motion> motions = new ArrayList<>();

    public List<Motion> getMotions() 
    {
        return motions;
    }

    public RopeBridge_Parser(List<String> input)
    {
        super(input);
    }

    @Override
    public void parse()
    {
        Direction.dirStrsInUse = Direction.URDL_DIRSTRS;
        for (String line : input)
            motions.add(Motion.fromAocInput(line));
    }

}
