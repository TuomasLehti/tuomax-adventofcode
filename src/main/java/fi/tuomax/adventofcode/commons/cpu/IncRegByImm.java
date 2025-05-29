package fi.tuomax.adventofcode.commons.cpu;

/**
 * Instruction to increment a register by an immediate value. 
 * The result is stored in the register.
 * 
 * reg = reg + imm
 */
public class IncRegByImm 
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

    public IncRegByImm(Cpu cpu, String regName, Long value)
    {
        super(cpu);
        this.regName = regName;
        this.value = value;
    }

    @Override
    public void run() 
    {
        cpu.setRegister(regName, cpu.getRegister(regName) + value);
    }

    
}
