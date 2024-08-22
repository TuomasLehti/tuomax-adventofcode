package fi.tuomax.adventofcode.commons.cpu;

/**
 * Provides instructions for the generic Cpu.
 */
public abstract class InstructionFactory 
{

    public abstract Instruction fromAocInput(String input);
    
}
