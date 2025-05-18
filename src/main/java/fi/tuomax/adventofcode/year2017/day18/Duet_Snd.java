package fi.tuomax.adventofcode.year2017.day18;

import fi.tuomax.adventofcode.commons.cpu.Cpu;
import fi.tuomax.adventofcode.commons.cpu.Instruction;

public class Duet_Snd 
extends Instruction
{

    public static Long lastPlayed = 0L;

    public Duet_Snd(String input, Cpu cpu) 
    {
        super(input, cpu);
    }

    @Override
    public void run(Cpu cpu) 
    {
        Duet_Snd.lastPlayed = arguments.get(0).getValue();
    }

    @Override
    public Instruction toggle() 
    {
        throw new UnsupportedOperationException("Unimplemented method 'toggle'");
    }

}
