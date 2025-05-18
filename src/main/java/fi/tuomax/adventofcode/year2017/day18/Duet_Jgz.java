package fi.tuomax.adventofcode.year2017.day18;

import fi.tuomax.adventofcode.commons.cpu.Cpu;
import fi.tuomax.adventofcode.commons.cpu.Instruction;

public class Duet_Jgz
extends Instruction
{

    public Duet_Jgz(String input, Cpu cpu) {
        super(input, cpu);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void run(Cpu cpu) 
    {
        if (arguments.get(0).getValue() > 0) {
            cpu.jump(arguments.get(1).getValue());
        }
    }

    @Override
    public Instruction toggle() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toggle'");
    }

}
