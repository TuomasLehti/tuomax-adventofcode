package fi.tuomax.adventofcode.commons.cpu;

/**
 * Instruction to multiply a register and an immediate value. 
 * The result is stored in the register.
 * 
 * reg = reg * imm
 */
public class MulRegByImm 
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

    public MulRegByImm(Cpu cpu, String regName, Long value)
    {
        super(cpu);
        this.regName = regName;
        this.value = value;
    }

    @Override
    public void run() 
    {
        cpu.setRegister(regName, cpu.getRegister(regName) * value);
    }

    
}
