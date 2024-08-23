package fi.tuomax.adventofcode.year2016.day23;

import fi.tuomax.adventofcode.commons.cpu.Cpu;
import fi.tuomax.adventofcode.commons.cpu.Instruction;
import fi.tuomax.adventofcode.commons.cpu.InstructionFactory;

public class Tgl 
extends Instruction
{

    public Tgl(String input, Cpu cpu) 
    {
        super(input, cpu);
    }

    @Override
    public void run(Cpu cpu) 
    {
        Integer offset = arguments.get(0).getValue();
        Integer targetAddr = cpu.getProgramCounter() + offset;
        try {
            Instruction target = cpu.getInstruction(targetAddr);
            cpu.setInstruction(targetAddr, target.toggle());
        } catch (IndexOutOfBoundsException e) {
            return;
        }
    }

    @Override
    public Instruction toggle() 
    {
        return InstructionFactory.inUse().fromAocInput(
            "inc " + arguments.get(0).toString(), cpu
        );
    }

}
