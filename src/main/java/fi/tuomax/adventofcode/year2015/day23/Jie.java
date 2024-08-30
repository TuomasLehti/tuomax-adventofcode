package fi.tuomax.adventofcode.year2015.day23;

import fi.tuomax.adventofcode.commons.cpu.Cpu;
import fi.tuomax.adventofcode.commons.cpu.Instruction;

/** Jumps if a value in a register is even. */
public class Jie 
extends Instruction
{

    public Jie(String input, Cpu cpu) 
    {
        super(input, cpu);
    }

    @Override
    public void run(Cpu cpu) 
    {
        Integer comparee = arguments.get(0).getValue();
        if ((comparee % 2) == 0)
            cpu.jump(arguments.get(1).getValue());
    }

    @Override
    public Instruction toggle() 
    {
        // Toggling not needed in 2015 day 23
        return this;
    }
    
}
