package fi.tuomax.adventofcode.commons.cpu;

public class Increment 
extends Instruction
{

    private Argument accumulator;
    
    public Argument getAccumulator() 
    {
        return accumulator;
    }

    private Argument amount;

    public Argument getAmount() 
    {
        return amount;
    }

    public Increment(Cpu cpu, Argument accumulator, Argument amount)
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
                cpu.getRegister(accumulator.getRegister()) + amount.getValue()
            );
        }
    }
    
}
