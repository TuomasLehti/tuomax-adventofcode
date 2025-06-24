package fi.tuomax.adventofcode.year2017.day18;

import fi.tuomax.adventofcode.commons.cpu.Argument;
import fi.tuomax.adventofcode.commons.cpu.Cpu;
import fi.tuomax.adventofcode.commons.cpu.Instruction;

public class Modulo 
extends Instruction
{

    private Argument value;
    
    private Argument accumulator;

    public Modulo(Cpu cpu, Argument accumulator, Argument value) 
    {
        super(cpu);
        this.accumulator = accumulator;
        this.value = value;
    }

    @Override
    public void run() 
    {
        cpu.setRegister(
            accumulator.getRegister(), 
            cpu.getRegister(accumulator.getRegister()) % value.getValue()
        );
    }
    
}
