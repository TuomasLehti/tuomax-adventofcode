package fi.tuomax.adventofcode.year2016.day23;

import fi.tuomax.adventofcode.commons.cpu.Cpu;
import fi.tuomax.adventofcode.commons.cpu.Instruction;
import fi.tuomax.adventofcode.year2016.day12.LeonardosMonorail_InstructionFactory;

public class SafeCracking_InstructionFactory 
extends LeonardosMonorail_InstructionFactory
{

    @Override
    public Instruction fromAocInput(String input, Cpu cpu)
    {
        if (input.startsWith("tgl")) return new Tgl(input, cpu);
        else return super.fromAocInput(input, cpu);
    }

    
}
