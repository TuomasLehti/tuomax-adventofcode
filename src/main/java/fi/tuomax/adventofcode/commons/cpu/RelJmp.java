package fi.tuomax.adventofcode.commons.cpu;

/**
 * The base class for instructions that perform an unconditional jump to a 
 * target address computed as an offset from the program counter.
 * 
 * The jump offset is an integer, because the program counter is an 32-bit 
 * value, which in turn is so because the instruction are stored in a List,
 * which use integer indexing in Java.
 */
public abstract class RelJmp 
extends Instruction
{

    protected abstract Integer getOffset();

    public RelJmp(Cpu cpu)
    {
        super(cpu);
    }

    @Override
    public void run() 
    {
        if (shouldJump())
            cpu.jump(getOffset());
    }

    protected abstract Boolean shouldJump();
    
}
