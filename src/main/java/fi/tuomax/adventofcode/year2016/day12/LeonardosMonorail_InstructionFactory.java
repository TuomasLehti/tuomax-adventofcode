package fi.tuomax.adventofcode.year2016.day12;

import fi.tuomax.adventofcode.commons.cpu.Argument;
import fi.tuomax.adventofcode.commons.cpu.Copy;
import fi.tuomax.adventofcode.commons.cpu.Cpu;
import fi.tuomax.adventofcode.commons.cpu.Increment;
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
        String[] parts = line.split(" ");

        if (line.startsWith("cpy")) 
            return new Copy(cpu, new Argument(cpu, parts[1]), new Argument(cpu, parts[2]));
        
        else if (line.startsWith("inc")) 
            return new Increment(cpu, new Argument(cpu, parts[1]), new Argument(cpu, "1"));
            
        else if (line.startsWith("dec")) 
            return new Increment(cpu, new Argument(cpu, parts[1]), new Argument(cpu, "-1"));

        else if (line.startsWith("jnz")) 
            return new JumpIfNotZero(cpu, new Argument(cpu, parts[1]), new Argument(cpu, parts[2]));
        
        else throw new IllegalArgumentException(
            "Unknown instruction: " + line
        );
}
    
}
