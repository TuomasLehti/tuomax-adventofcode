package fi.tuomax.adventofcode.year2015.day23;

import java.util.List;

import fi.tuomax.adventofcode.framework.parsing.Parser;

public class OpeningTheTuringLock_Parser 
extends Parser
{

    private CPU cpu = new CPU();

    public CPU getCpu() 
    {
        return cpu;
    }

    public OpeningTheTuringLock_Parser(List<String> input) 
    {
        super(input);
    }

    @Override
    public void parse() 
    {
        for (String line : input) {
            cpu.enterProgram(line);
        }
    }
    
}
