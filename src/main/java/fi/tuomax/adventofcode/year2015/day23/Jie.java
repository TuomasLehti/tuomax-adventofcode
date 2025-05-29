package fi.tuomax.adventofcode.year2015.day23;

import fi.tuomax.adventofcode.commons.cpu.Cpu;
import fi.tuomax.adventofcode.commons.cpu.RelJmp;

/** Jumps if a value in a register is even. */
public class Jie 
extends RelJmp
{

    String regName = "";

    public Jie(Cpu cpu, Integer offset, String regName) 
    {
        super(cpu, offset);
        this.regName = regName;
    }

    public Boolean shouldJump()
    {
        return (cpu.getRegister(regName) % 2L) == 0L;
    }

    
}
