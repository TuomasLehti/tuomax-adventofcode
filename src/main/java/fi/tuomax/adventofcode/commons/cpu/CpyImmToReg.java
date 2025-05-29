package fi.tuomax.adventofcode.commons.cpu;

/**
 * Instruction to copy an immediate value to a register.
 */
public class CpyImmToReg 
extends Instruction
{

    private String regName = "";

    protected void setRegName(String regName) 
    {
        this.regName = regName;
    }

    private Long value = 0L;

    protected void setValue(Long value) 
    {
        this.value = value;
    }

    public CpyImmToReg(Cpu cpu, String regName, Long value)
    {
        super(cpu);
        this.regName = regName;
        this.value = value;
    }

    @Override
    public void run() 
    {
        cpu.setRegister(regName, value);
    }
    
}
