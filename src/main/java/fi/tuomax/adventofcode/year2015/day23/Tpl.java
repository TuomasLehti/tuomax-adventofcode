package fi.tuomax.adventofcode.year2015.day23;

import fi.tuomax.adventofcode.commons.cpu.Cpu;
import fi.tuomax.adventofcode.commons.cpu.Instruction;

/** Triples the value of a register. */
public class Tpl 
extends Instruction
{

    public Tpl(String input, Cpu cpu) 
    {
        super(input, cpu);
    }

    @Override
    public void run(Cpu cpu) 
    {
        String targetRegister = arguments.get(0).getRegister();
        cpu.setRegister(targetRegister, cpu.getRegister(targetRegister) * 3);
    }

    @Override
    public Instruction toggle() 
    {
        // Toggling not needed in 2015 day 23
        return this;
    }
    
}
