package fi.tuomax.adventofcode.year2016.day12;

import fi.tuomax.adventofcode.commons.cpu.Argument;
import fi.tuomax.adventofcode.commons.cpu.ConditionalJump;
import fi.tuomax.adventofcode.commons.cpu.Cpu;

public class JumpIfNotZero 
extends ConditionalJump
{

    public JumpIfNotZero(Cpu cpu, Argument condition, Argument offset) 
    {
        super(cpu, condition, offset);
    }

    public Boolean shouldJump()
    {
        return !getCondition().getValue().equals(0L);
    }
    
}
