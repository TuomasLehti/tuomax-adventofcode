package fi.tuomax.adventofcode.commons.cpu;

public class Divide 
extends Instruction
{

    private Argument accumulator;
    
    private Argument amount;

    public Divide(Cpu cpu, Argument accumulator, Argument amount)
    {
        super(cpu);
        this.accumulator = accumulator;
        this.amount = amount;
    }

    @Override
    public void run() 
    {
        if (!accumulator.isRegister()) {
            cpu.stop();
        } else {
            cpu.setRegister(
                accumulator.getRegister(), 
                cpu.getRegister(accumulator.getRegister()) / amount.getValue()
            );
        }
    }

}
