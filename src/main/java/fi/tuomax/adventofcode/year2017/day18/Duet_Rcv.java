package fi.tuomax.adventofcode.year2017.day18;

import org.slf4j.LoggerFactory;

import fi.tuomax.adventofcode.commons.cpu.Argument;
import fi.tuomax.adventofcode.commons.cpu.Cpu;
import fi.tuomax.adventofcode.commons.cpu.Instruction;

public class Duet_Rcv
extends Instruction
{

    private Argument condition;

    public Duet_Rcv(Cpu cpu, Argument condition) 
    {
        super(cpu);
        this.condition = condition;
    }

    @Override
    public void run() 
    {
        if (!condition.getValue().equals(0L)) {
            LoggerFactory.getLogger(getClass()).debug("Recovered " + Duet_Snd.lastPlayed);
            cpu.stop();
        }
    }

}
