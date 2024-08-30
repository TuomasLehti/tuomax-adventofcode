package fi.tuomax.adventofcode.year2015.day23;

import fi.tuomax.adventofcode.commons.cpu.Cpu;
import fi.tuomax.adventofcode.commons.cpu.Instruction;

/** Jumps if a value of a register is <em>ONE</em>, not odd. */
public class Jio
extends Instruction 
{

    public Jio(String input, Cpu cpu) 
    {
        super(input, cpu);
    }

    @Override
    public void run(Cpu cpu) 
    {
        Integer comparee = arguments.get(0).getValue();
        if (comparee.equals(1))
            cpu.jump(arguments.get(1).getValue());
    }

    @Override
    public Instruction toggle() 
    {
        // Toggling not needed in 2015 day 23
        return this;
    }
    
}
