package fi.tuomax.adventofcode.year2017.day18;

import fi.tuomax.adventofcode.commons.cpu.Cpu;
import fi.tuomax.adventofcode.commons.cpu.Instruction;

public class Duet_Add 
extends Instruction
{

    public Duet_Add(String input, Cpu cpu) 
    {
        super(input, cpu);
    }

    @Override
    public void run(Cpu cpu) 
    {
        if (!arguments.get(0).isRegister()) return;
        String accumulatorName = arguments.get(0).getRegister();
        Long accumulatorValue = cpu.getRegister(accumulatorName);
        Long argumentValue = arguments.get(1).getValue();
        cpu.setRegister(accumulatorName, accumulatorValue + argumentValue);
    }

    @Override
    public Instruction toggle() 
    {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toggle'");
    }

}
