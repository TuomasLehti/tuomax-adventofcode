package fi.tuomax.adventofcode.year2022.day20;

import java.util.List;

import fi.tuomax.adventofcode.framework.parsing.Parser;

public abstract class GrovePositioningSystem_Parser
extends Parser
{

    private GpsMixer nums = new GpsMixer();

    public GpsMixer getNums() 
    {
        return nums;
    }

    public GrovePositioningSystem_Parser(List<String> input)
    {
        super(input);
    }

    @Override
    public void parse()
    {
        for (String line : input) {
            nums.addNumber(aocInputToLong(line));
        }
    }

    protected abstract long aocInputToLong(String line);

}
