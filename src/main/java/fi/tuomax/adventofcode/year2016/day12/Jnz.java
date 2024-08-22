package fi.tuomax.adventofcode.year2016.day12;

import fi.tuomax.adventofcode.commons.cpu.Cpu;
import fi.tuomax.adventofcode.commons.cpu.Instruction;
import fi.tuomax.adventofcode.commons.cpu.InstructionFactory;

public class Jnz 
extends Instruction
{


    public Jnz(String input, Cpu cpu) 
    {
        super(input, cpu);
    }

    @Override
    public void run(Cpu cpu) 
    {
        Integer comparee = arguments.get(0).getValue();
        if (!comparee.equals(0))
            cpu.jump(arguments.get(1).getValue());
    }

    @Override
    public Instruction toggle() 
    {
        return InstructionFactory.inUse().fromAocInput(
            String.format(
                "cpy %s %s",
                arguments.get(0).toString(),
                arguments.get(1).toString()
            ),
            cpu
        );
    }
    
}
