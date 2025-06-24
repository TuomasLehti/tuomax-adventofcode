package fi.tuomax.adventofcode.commons.cpu;

public abstract class ConditionalJump 
extends Instruction
{

    private Argument condition;

    public Argument getCondition()
    {
        return condition;
    }

    private Argument offset;

    public Argument getOffset() 
    {
        return offset;
    }

    public ConditionalJump(Cpu cpu, Argument condition, Argument offset)
    {
        super(cpu);
        this.condition = condition;
        this.offset = offset;
    }

    @Override
    public void run() 
    {
        if (shouldJump())
            cpu.jump((int) (offset.getValue() % Integer.MAX_VALUE));
    }

    protected abstract Boolean shouldJump();
    
}
