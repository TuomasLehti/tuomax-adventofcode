package fi.tuomax.adventofcode.year2015.day23;

import fi.tuomax.adventofcode.commons.cpu.Cpu;
import fi.tuomax.adventofcode.commons.cpu.Instruction;

/** Halves the value of a register. Remainder is discarded. */
public class Hlf 
extends Instruction
{

    public Hlf(String input, Cpu cpu) 
    {
        super(input, cpu);
    }

    @Override
    public void run(Cpu cpu) 
    {
        String targetRegister = arguments.get(0).getRegister();
        cpu.setRegister(targetRegister, cpu.getRegister(targetRegister) / 2);
    }

    @Override
    public Instruction toggle() 
    {
        // Toggling not needed in 2015 day 23
        return this;
    }
    
}
