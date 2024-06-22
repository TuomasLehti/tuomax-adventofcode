package fi.tuomax.adventofcode.year2015.day20;

import java.util.List;
import fi.tuomax.adventofcode.framework.parsing.Parser;

public class InfiniteElvesAndInfiniteHouses_Parser 
extends Parser
{
   
    public InfiniteElvesAndInfiniteHouses_Parser(List<String> input) 
    {
        super(input);
    }

    private Long target;

    public Long getTarget() 
    {
        return target;
    }

    @Override
    public void parse() 
    {
        target = Long.valueOf(input.get(0));
    }
    
}
