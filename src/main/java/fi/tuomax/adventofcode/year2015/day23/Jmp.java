package fi.tuomax.adventofcode.year2015.day23;

import fi.tuomax.adventofcode.commons.cpu.Cpu;
import fi.tuomax.adventofcode.commons.cpu.Instruction;

/** Unconditional jump. */
public class Jmp 
extends Instruction 
{

    public Jmp(String input, Cpu cpu) 
    {
        super(input, cpu);
    }

    @Override
    public void run(Cpu cpu) 
    {
        cpu.jump((int) (arguments.get(0).getValue() % Integer.MAX_VALUE)); 
    }

    @Override
    public Instruction toggle() 
    {
        // Toggling not needed in 2015 day 23
        return this;
    }
    
}
