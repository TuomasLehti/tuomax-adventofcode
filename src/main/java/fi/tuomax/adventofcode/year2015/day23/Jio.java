package fi.tuomax.adventofcode.year2015.day23;

import fi.tuomax.adventofcode.commons.cpu.Cpu;
import fi.tuomax.adventofcode.commons.cpu.RelJmpOfsFromImm;

/** Jumps if a value of a register is <em>ONE</em>, not odd. */
public class Jio
extends RelJmpOfsFromImm
{

    String regName = "";

    public Jio(Cpu cpu, Integer offset, String regName) 
    {
        super(cpu, offset);
        this.regName = regName;
    }

    public Boolean shouldJump()
    {
        return cpu.getRegister(regName).equals(1L);
    }
    
}
