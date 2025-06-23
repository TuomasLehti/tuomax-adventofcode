package fi.tuomax.adventofcode.year2016.day12;

import fi.tuomax.adventofcode.commons.cpu.Cpu;
import fi.tuomax.adventofcode.commons.cpu.RelJmpOfsFromImm;

public class Jnz 
extends RelJmpOfsFromImm
{

    String regName = "";

    public Jnz(Cpu cpu, Integer offset, String regName) 
    {
        super(cpu, offset);
        this.regName = regName;
    }

    public Boolean shouldJump()
    {
        return cpu.getRegister(regName) != 0;
    }
    
}
