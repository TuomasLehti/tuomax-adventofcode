package fi.tuomax.adventofcode.commons.cpu;

/**
 * Provides instructions for the generic Cpu.
 */
public abstract class InstructionFactory 
{

    private static InstructionFactory inUse = null;

    public static InstructionFactory inUse()
    {
        return InstructionFactory.inUse;
    }

    public void use(InstructionFactory factory)
    {
        InstructionFactory.inUse = factory;
    }

    public abstract Instruction fromAocInput(String input, Cpu cpu);
    
}
