package fi.tuomax.adventofcode.year2016.day02;

import java.util.ArrayList;
import java.util.List;

import fi.tuomax.adventofcode.commons.Direction;
import fi.tuomax.adventofcode.framework.parsing.Parser;

public class BathroomSecurity_Parser 
extends Parser
{

    private List<List<Direction>> instructions = new ArrayList<>();

    public List<List<Direction>> getInstructions() 
    {
        return instructions;
    }

    public BathroomSecurity_Parser(List<String> input) 
    {
        super(input);
    }

    @Override
    public void parse() 
    {
        Direction.dirStrsInUse = Direction.URDL_DIRSTRS;
        for (String line : input) {
            List<Direction> row = new ArrayList<>();
            for (String dir : line.split("")) 
                row.add(Direction.fromString(dir));
            instructions.add(row);
        }
    }
    
}
