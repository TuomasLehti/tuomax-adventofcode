package fi.tuomax.adventofcode.year2016.day25;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fi.tuomax.adventofcode.commons.cpu.Cpu;
import fi.tuomax.adventofcode.commons.cpu.Instruction;

public class Out 
extends Instruction
{

    private static Logger LOGGER = LoggerFactory.getLogger(Out.class);

    public Out(String input, Cpu cpu) 
    {
        super(input, cpu);
    }

    @Override
    public void run(Cpu cpu) 
    {
        System.out.print(arguments.get(0).getValue().toString());
    }

    /** No toggling in Aoc 2016 day 25. */
    @Override
    public Instruction toggle() 
    {
        return this;
    }
    
}
