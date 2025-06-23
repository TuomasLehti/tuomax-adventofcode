package fi.tuomax.adventofcode.commons.cpu;

public class Copy 
extends Instruction
{

    private Argument source;

    private Argument target;

    public Copy(Cpu cpu, Argument source, Argument target)
    {
        super(cpu);
        this.source = source;
        this.target = target;
    }

    @Override
    public void run() 
    {
        if (!target.isRegister()) {
            cpu.stop();
        } else {
            cpu.setRegister(target.getRegister(), source.getValue());
        }
    }
    
}
