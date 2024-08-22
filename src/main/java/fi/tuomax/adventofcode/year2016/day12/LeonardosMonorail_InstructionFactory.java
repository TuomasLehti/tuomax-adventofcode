package fi.tuomax.adventofcode.year2016.day12;

import fi.tuomax.adventofcode.commons.cpu.Instruction;
import fi.tuomax.adventofcode.commons.cpu.InstructionFactory;

/**
 * Provides Assembunny instructions from Aoc 2016, day 12.
 */
public class LeonardosMonorail_InstructionFactory 
extends InstructionFactory
{

    @Override
    public Instruction fromAocInput(String line) 
    throws IllegalArgumentException
    {
        if (line.startsWith("cpy")) return new Cpy(line);
        else if (line.startsWith("inc")) return new Inc(line);
        else if (line.startsWith("dec")) return new Dec(line);
        else if (line.startsWith("jnz")) return new Jnz(line);
        else throw new IllegalArgumentException(
            "Unknown instruction: " + line
        );
}
    
}
