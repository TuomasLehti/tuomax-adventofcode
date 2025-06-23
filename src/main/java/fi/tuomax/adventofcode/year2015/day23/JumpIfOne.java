package fi.tuomax.adventofcode.year2015.day23;

import fi.tuomax.adventofcode.commons.cpu.Argument;
import fi.tuomax.adventofcode.commons.cpu.ConditionalJump;
import fi.tuomax.adventofcode.commons.cpu.Cpu;

/** Jumps if a value of a register is <em>ONE</em>, not odd. */
public class JumpIfOne
extends ConditionalJump
{

    public JumpIfOne(Cpu cpu, Argument condition, Argument offset) 
    {
        super(cpu, condition, offset);
    }

    public Boolean shouldJump()
    {
        return getCondition().getValue().equals(1L);
    }
    
}
