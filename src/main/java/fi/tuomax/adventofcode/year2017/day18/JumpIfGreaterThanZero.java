package fi.tuomax.adventofcode.year2017.day18;

import fi.tuomax.adventofcode.commons.cpu.Argument;
import fi.tuomax.adventofcode.commons.cpu.ConditionalJump;
import fi.tuomax.adventofcode.commons.cpu.Cpu;

public class JumpIfGreaterThanZero 
extends ConditionalJump
{

    public JumpIfGreaterThanZero(Cpu cpu, Argument condition, Argument offset) 
    {
        super(cpu, condition, offset);
    }

    @Override
    protected Boolean shouldJump() 
    {
        return getCondition().getValue() > 0;
    }
    
}
