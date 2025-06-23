package fi.tuomax.adventofcode.commons.cpu;

public class Copy 
extends Instruction
{

    private Argument source;

    public Argument getSource() 
    {
        return source;
    }

    private Argument destination;

    public Argument getDestination() 
    {
        return destination;
    }

    public void setDestination(Argument target) 
    {
        this.destination = target;
    }

    public Copy(Cpu cpu, Argument source, Argument target)
    {
        super(cpu);
        this.source = source;
        this.destination = target;
    }

    @Override
    public void run() 
    {
        if (!destination.isRegister()) {
            cpu.stop();
        } else {
            cpu.setRegister(destination.getRegister(), source.getValue());
        }
    }
    
}
