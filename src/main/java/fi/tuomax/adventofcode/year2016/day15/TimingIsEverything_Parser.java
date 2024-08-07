package fi.tuomax.adventofcode.year2016.day15;

import java.util.ArrayList;
import java.util.List;

import fi.tuomax.adventofcode.framework.parsing.Parser;

public class TimingIsEverything_Parser 
extends Parser
{

    public TimingIsEverything_Parser(List<String> input) 
    {
        super(input);
    }

    private List<Disc> discs = new ArrayList<>();

    public List<Disc> getDiscs() 
    {
        return discs;
    }

    @Override
    public void parse() 
    {
        for (String line : input)
            discs.add(Disc.fromInput(line));
    }

    
}
