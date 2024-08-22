package fi.tuomax.adventofcode.year2016.day12;

import fi.tuomax.adventofcode.commons.cpu.Cpu;
import fi.tuomax.adventofcode.commons.cpu.Instruction;
import fi.tuomax.adventofcode.commons.cpu.InstructionFactory;

/**
 * Provides Assembunny instructions from Aoc 2016, day 12.
 */
public class LeonardosMonorail_InstructionFactory 
extends InstructionFactory
{

    @Override
    public Instruction fromAocInput(String line, Cpu cpu) 
    throws IllegalArgumentException
    {
        if (line.startsWith("cpy")) return new Cpy(line, cpu);
        else if (line.startsWith("inc")) return new Inc(line, cpu);
        else if (line.startsWith("dec")) return new Dec(line, cpu);
        else if (line.startsWith("jnz")) return new Jnz(line, cpu);
        else throw new IllegalArgumentException(
            "Unknown instruction: " + line
        );
}
    
}
