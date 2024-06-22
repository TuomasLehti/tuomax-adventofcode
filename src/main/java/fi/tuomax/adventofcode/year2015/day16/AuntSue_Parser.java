package fi.tuomax.adventofcode.year2015.day16;

import java.util.ArrayList;
import java.util.List;

import fi.tuomax.adventofcode.framework.parsing.Parser;

public class AuntSue_Parser 
extends Parser
{

    private List<Sue> sues = new ArrayList<>();

    public List<Sue> getSues() 
    {
        return sues;
    }

    public AuntSue_Parser(List<String> input) 
    {
        super(input);
    }

    @Override
    public void parse() 
    {
        for (String line : input)
            sues.add(Sue.fromInput(line));
    }
    
}
