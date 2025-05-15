package fi.tuomax.adventofcode.year2017.day15;

import java.util.List;

import fi.tuomax.adventofcode.framework.parsing.Parser;

public class DuelingGenerators_Parser
extends Parser
{

    private Long genAStart;

    public Long getGenAStart() 
    {
        return genAStart;
    }

    private Long genBStart;

    public Long getGenBStart() {
        
        return genBStart;
    }

    public DuelingGenerators_Parser(List<String> input)
    {
        super(input);
    }

    @Override
    public void parse()
    {
        genAStart = Long.valueOf(input.get(0).split(" ")[4]);
        genBStart = Long.valueOf(input.get(1).split(" ")[4]);
    }

}
