package fi.tuomax.adventofcode.year2016.day12;

import fi.tuomax.adventofcode.commons.cpu.Cpu;
import fi.tuomax.adventofcode.commons.cpu.Instruction;
import fi.tuomax.adventofcode.commons.cpu.InstructionFactory;

public class Inc 
extends Instruction
{

    public Inc(String input, Cpu cpu) {
        super(input, cpu);
    }

    @Override
    public void run(Cpu cpu) 
    {
        cpu.setRegister(
            arguments.get(0).getRegister(), 
            cpu.getRegister(arguments.get(0).getRegister()) + 1
        );
    }

    @Override
    public Instruction toggle() 
    {
        return InstructionFactory.inUse().fromAocInput(
            String.format(
                "dec %s",
                arguments.get(0).toString()
            ),
            cpu
        );
    }
    
}
