package fi.tuomax.adventofcode.year2017.day23;

import fi.tuomax.adventofcode.commons.cpu.Argument;
import fi.tuomax.adventofcode.commons.cpu.Cpu;
import fi.tuomax.adventofcode.commons.cpu.Instruction;

public class Decrement 
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

    public Decrement(Cpu cpu, Argument accumulator, Argument amount)
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
                cpu.getRegister(accumulator.getRegister()) - amount.getValue()
            );
        }
    }
    
}
