package fi.tuomax.adventofcode.year2016.day12;

import fi.tuomax.adventofcode.commons.cpu.Cpu;
import fi.tuomax.adventofcode.commons.cpu.Instruction;
import fi.tuomax.adventofcode.commons.cpu.InstructionFactory;

public class Cpy 
extends Instruction
{

    public Cpy(String input, Cpu cpu) {
        super(input, cpu);
    }

    @Override
    public void run(Cpu cpu) 
    {
        if (!arguments.get(1).isRegister()) return;
        cpu.setRegister(
            arguments.get(1).getRegister(),
            arguments.get(0).getValue()
        );
    }

    @Override
    public Instruction toggle() 
    {
        return InstructionFactory.inUse().fromAocInput(
            String.format(
                "jnz %s %s",
                arguments.get(0).toString(),
                arguments.get(1).toString()
            ),
            cpu
        );
    }
    
}
