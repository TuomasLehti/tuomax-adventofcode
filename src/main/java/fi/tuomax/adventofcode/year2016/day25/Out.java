package fi.tuomax.adventofcode.year2016.day25;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fi.tuomax.adventofcode.commons.cpu.Argument;
import fi.tuomax.adventofcode.commons.cpu.Cpu;
import fi.tuomax.adventofcode.commons.cpu.Instruction;

public class Out 
extends Instruction
{

    private Argument argument;

    private static Logger LOGGER = LoggerFactory.getLogger(Out.class);

    public Out(Cpu cpu, Argument argument) 
    {
        super(cpu);
        this.argument = argument;
    }

    @Override
    public void run() 
    {
        System.out.print(argument.getValue().toString());
    }
    
}
