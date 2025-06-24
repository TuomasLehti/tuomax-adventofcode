package fi.tuomax.adventofcode.commons.cpu;

/**
 * No operation instruction. Does nothing.
 */
public class Nop 
extends Instruction
{

    public Nop(Cpu cpu) 
    {
        super(cpu);
    }

    @Override
    public void run() 
    {
        /* No operation literally does nothing. */
    }
    
}
