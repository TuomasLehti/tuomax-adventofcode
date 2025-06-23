package fi.tuomax.adventofcode.commons.cpu;

/**
 * The base class for instructions that perform an unconditional jump to a 
 * target address computed as an offset from the program counter. The offset
 * is read from a register.
 */
public class RelJmpOfsFromReg 
extends RelJmp
{

    private String regName = "";

    public RelJmpOfsFromReg(Cpu cpu, String regName) 
    {
        super(cpu);
        this.regName = regName;
    }

    @Override
    protected Integer getOffset() 
    {
        return (int) (cpu.getRegister(regName) % Integer.MAX_VALUE);
    }

    @Override
    protected Boolean shouldJump() 
    {
        return true;
    }
    
}
