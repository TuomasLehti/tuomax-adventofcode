package fi.tuomax.adventofcode.commons.cpu;

public class UnconditionalJump 
extends ConditionalJump
{

    public UnconditionalJump(Cpu cpu, Argument offset) {
        super(cpu, null, offset);
    }

    @Override
    protected Boolean shouldJump() {
        return true;
    }
    
}
