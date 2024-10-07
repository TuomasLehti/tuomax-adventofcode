package fi.tuomax.adventofcode.year2022.day20;

import java.util.List;

public class GrovePositioningSystem_Parser_Part1
extends GrovePositioningSystem_Parser
{

    public GrovePositioningSystem_Parser_Part1(List<String> input)
    {
        super(input);
    }

    @Override
    protected long aocInputToLong(String line) 
    {
        return Long.valueOf(line);
    }

}
