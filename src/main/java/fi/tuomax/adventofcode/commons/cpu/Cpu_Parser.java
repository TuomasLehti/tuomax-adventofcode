package fi.tuomax.adventofcode.commons.cpu;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import fi.tuomax.adventofcode.framework.parsing.Parser;

public class Cpu_Parser 
extends Parser
{

    private Cpu cpu = new Cpu(new HashSet<String>(
            Arrays.asList(new String[]{"a", "b", "c", "d"})));

    private InstructionFactory factory;

    public Cpu getCpu() 
    {
        return cpu;
    }

    public Cpu_Parser(List<String> input, InstructionFactory factory) 
    {
        super(input);
        this.factory = factory;
    }

    @Override
    public void parse() 
    {
        for (String line : input) {
            cpu.enterProgram(factory.fromAocInput(line, cpu));
        }
    }
    
}
