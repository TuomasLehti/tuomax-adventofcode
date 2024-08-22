package fi.tuomax.adventofcode.year2016.day12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import fi.tuomax.adventofcode.commons.cpu.Cpu;
import fi.tuomax.adventofcode.commons.cpu.InstructionFactory;
import fi.tuomax.adventofcode.framework.parsing.Parser;

public class LeonardosMonorail_Parser 
extends Parser
{

    private Cpu cpu = new Cpu(new HashSet<String>(
            Arrays.asList(new String[]{"a", "b", "c", "d"})));

    public Cpu getCpu() 
    {
        return cpu;
    }

    public LeonardosMonorail_Parser(List<String> input) 
    {
        super(input);
    }

    @Override
    public void parse() 
    {
        InstructionFactory factory = new LeonardosMonorail_InstructionFactory();
        for (String line : input) {
            cpu.enterProgram(factory.fromAocInput(line));
        }
    }
    
}
