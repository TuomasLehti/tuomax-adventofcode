package fi.tuomax.adventofcode.commons.cpu;

/**
 * Instruction to copy an immediate value to a register.
 */
public class CpyRegToReg 
extends Instruction
{

    private String srcRegName = "";

    private String destRegName = "";

    protected void setSrcRegName(String regName) 
    {
        this.srcRegName = regName;
    }

    protected void setDestRegName(String regName) 
    {
        this.destRegName = regName;
    }


    public CpyRegToReg(Cpu cpu, String destRegName, String srcRegName)
    {
        super(cpu);
        this.destRegName = destRegName;
        this.srcRegName = srcRegName;
    }

    @Override
    public void run() 
    {
        cpu.setRegister(destRegName, cpu.getRegister(srcRegName));
    }
    
}
