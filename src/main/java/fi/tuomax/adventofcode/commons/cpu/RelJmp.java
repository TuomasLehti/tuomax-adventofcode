package fi.tuomax.adventofcode.commons.cpu;

/**
 * An instruction for an unconditional jump. This class also serves as a base
 * class for conditional jumps, in which case the child classes should override
 * the method which determines the condition.
 * 
 * The jump offset is an integer, because the program counter is an 32-bit 
 * value, which in turn is so because the instruction are stored in a List,
 * which use integer indexing in Java.
 */
public class RelJmp 
extends Instruction
{

    private Integer offset = 0;

    public RelJmp(Cpu cpu, Integer offset)
    {
        super(cpu);
        this.offset = offset;
    }

    @Override
    public void run() 
    {
        if (shouldJump())
            cpu.jump(offset);
    }

    public Boolean shouldJump()
    {
        return true;
    }
    
}
