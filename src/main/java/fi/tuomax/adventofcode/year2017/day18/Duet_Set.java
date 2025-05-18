package fi.tuomax.adventofcode.year2017.day18;

import fi.tuomax.adventofcode.commons.cpu.Cpu;
import fi.tuomax.adventofcode.commons.cpu.Instruction;

public class Duet_Set 
extends Instruction
{

    public Duet_Set(String input, Cpu cpu) 
    {
        super(input, cpu);
    }

    @Override
    public void run(Cpu cpu) 
    {
        if (!arguments.get(0).isRegister()) return;
        cpu.setRegister(arguments.get(0).getRegister(), arguments.get(1).getValue());
    }

    @Override
    public Instruction toggle() 
    {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toggle'");
    }

}
