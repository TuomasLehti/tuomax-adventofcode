package fi.tuomax.adventofcode.year2015.day23;

import fi.tuomax.adventofcode.commons.cpu.Argument;
import fi.tuomax.adventofcode.commons.cpu.ConditionalJump;
import fi.tuomax.adventofcode.commons.cpu.Cpu;

/** Jumps if a value in a register is even. */
public class JumpIfEven 
extends ConditionalJump
{

    public JumpIfEven(Cpu cpu, Argument condition, Argument offset) 
    {
        super(cpu, condition, offset);
    }

    public Boolean shouldJump()
    {
        return (getCondition().getValue() % 2L) == 0L;
    }

    
}
