package fi.tuomax.adventofcode.year2022.day20;

import java.util.List;

import fi.tuomax.adventofcode.framework.parsing.Parser;

public class GrovePositioningSystem_Parser
extends Parser
{

    private Nums nums = new Nums();

    public Nums getNums() 
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
            nums.add(Integer.valueOf(line));
        }
    }

}
