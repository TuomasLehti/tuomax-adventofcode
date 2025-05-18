package fi.tuomax.adventofcode.year2017.day18;

import org.slf4j.LoggerFactory;

import fi.tuomax.adventofcode.commons.cpu.Cpu;
import fi.tuomax.adventofcode.commons.cpu.Instruction;

public class Duet_Rcv
extends Instruction
{

    public Duet_Rcv(String input, Cpu cpu) {
        super(input, cpu);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void run(Cpu cpu) 
    {
        LoggerFactory.getLogger(getClass()).debug("Recovered " + Duet_Snd.lastPlayed);
        System.out.print("");
    }

    @Override
    public Instruction toggle() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toggle'");
    }

}
