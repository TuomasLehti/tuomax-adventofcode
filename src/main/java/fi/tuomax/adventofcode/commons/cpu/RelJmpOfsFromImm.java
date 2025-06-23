package fi.tuomax.adventofcode.commons.cpu;

/**
 * The base class for instructions that perform an unconditional jump to a 
 * target address computed as an offset from the program counter. The offset
 * is an immediate value.
 */
public class RelJmpOfsFromImm 
extends RelJmp
{

    private Integer offset = 0;

    public RelJmpOfsFromImm(Cpu cpu, Integer offset) 
    {
        super(cpu);
        this.offset = offset;
    }

    @Override
    protected Integer getOffset() 
    {
        return offset;
    }

    @Override
    protected Boolean shouldJump() 
    {
        return true;
    }
    
}
