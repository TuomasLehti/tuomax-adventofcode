package fi.tuomax.adventofcode.year2016.day25;

import fi.tuomax.adventofcode.commons.cpu.Cpu;
import fi.tuomax.adventofcode.commons.cpu.Instruction;
import fi.tuomax.adventofcode.year2016.day12.LeonardosMonorail_InstructionFactory;

public class ClockSignal_InstructionFactory 
extends LeonardosMonorail_InstructionFactory
{

    @Override
    public Instruction fromAocInput(String input, Cpu cpu)
    {
        if (input.startsWith("out")) return new Out(input, cpu);
        else return super.fromAocInput(input, cpu);
    }

    
}
