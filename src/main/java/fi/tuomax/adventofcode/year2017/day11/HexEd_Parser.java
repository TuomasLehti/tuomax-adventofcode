package fi.tuomax.adventofcode.year2017.day11;

import java.util.ArrayList;
import java.util.List;

import fi.tuomax.adventofcode.commons.Direction;
import fi.tuomax.adventofcode.framework.parsing.Parser;

public class HexEd_Parser
extends Parser
{

    private List<Direction> directions = new ArrayList<>();

    public List<Direction> getDirections() 
    {
        return directions;
    }

    public HexEd_Parser(List<String> input)
    {
        super(input);
    }

    @Override
    public void parse()
    {
        Direction.dirStrsInUse = Direction.COMPASS_DIRSTRS;
        for (String dir : input.get(0).split(",")) {
            directions.add(Direction.fromString(dir.toUpperCase()));
        }
    }

}
