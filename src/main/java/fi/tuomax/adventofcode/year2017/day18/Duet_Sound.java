package fi.tuomax.adventofcode.year2017.day18;

import fi.tuomax.adventofcode.commons.cpu.Argument;
import fi.tuomax.adventofcode.commons.cpu.Cpu;
import fi.tuomax.adventofcode.commons.cpu.Instruction;

public class Duet_Sound 
extends Instruction
{

    public static Long lastPlayed = 0L;
    
    private Argument sound;

    public Duet_Sound(Cpu cpu, Argument sound) 
    {
        super(cpu);
        this.sound = sound;
    }

    @Override
    public void run() 
    {
        Duet_Sound.lastPlayed = sound.getValue();
    }

}
